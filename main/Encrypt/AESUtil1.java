package Encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author tangdongfan
 * @date 2020/4/28 11:28
 * AES加密解密
 * pin在15位以内(一个中文当三位)，密文长度24，31位以内，密文长度44...
 */
public class AESUtil1 {

    private static final String seed = "outside_strategies@wdcshwdftdf";
    private static final SecretKeySpec key;

    // 生成加密秘钥
    static {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //AES 要求密钥长度为 128
        kg.init(128, new SecureRandom(seed.getBytes()));
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        key = new SecretKeySpec(secretKey.getEncoded(), "AES");// 转换为AES专用密钥
    }

     // AES加密操作
    public static String encrypt(String pin) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, key);
            // 加密操作
            byte[] result = cipher.doFinal(pin.getBytes("utf-8"));
            return Base64.getEncoder().encodeToString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // AES解密操作
    public static String decrypt(String encryptPin) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, key);
            //解密操作
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(encryptPin));
            return new String(result, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String content = "18201712787_测试asa";
        System.out.println("content:" + content);
        String s1 = AESUtil1.encrypt(content);
        System.out.println("密文长度: " + s1.length() + ",密文: " + s1);
        System.out.println("解密后:"+ AESUtil1.decrypt(s1));
    }

}