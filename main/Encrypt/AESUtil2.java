package Encrypt;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author tangdongfan
 * @date 2020/4/28 19:45
 * AES加密解密
 */
public class AESUtil2 {
    private static final IvParameterSpec DEFAULT_IV = new IvParameterSpec(new byte[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0});
    private static final String SEED = "outside-strategies";
    private static final SecretKeySpec key;

    static {
        // 创建AES的Key生产者
        KeyGenerator kgen = null;
        SecureRandom secureRandom = null;
        try {
            kgen = KeyGenerator.getInstance("AES");
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        secureRandom.setSeed(SEED.getBytes(StandardCharsets.UTF_8));
        kgen.init(128,secureRandom);
        // 根据用户密码，生成一个密钥
        SecretKey secretKey = kgen.generateKey();
        // 返回基本编码格式的密钥
        byte[] enCodeFormat = secretKey.getEncoded();
        // 转换为AES专用密钥
        key = new SecretKeySpec(enCodeFormat, "AES");
    }

    public static String encrypt(String pin) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            byte[] byteContent = (pin.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, key,DEFAULT_IV);
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //去掉换行符 base64超过76字符自动加换行符
            return Base64Util.encode2Str(result, "UTF-8", true).replaceAll("\r\n", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pin;
    }

    // 解密
    public static String decrypt(String encryptPin) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            // 初始化为解密模式的密码器
            cipher.init(Cipher.DECRYPT_MODE, key,DEFAULT_IV);
            byte[] result = cipher.doFinal(Base64Util.decode(encryptPin.getBytes(), true));
            // 明文
            return new String(result);
        } catch (Exception e){
            e.printStackTrace();
        }
        return encryptPin;
    }

    public static void main(String[] args) {
        String encrypt = encrypt("18201712787_测试asa");
        System.out.println("密文长度：" + encrypt.length() + ",密文：" + encrypt);
        System.out.println("解密后：" + decrypt(encrypt));
    }
}
