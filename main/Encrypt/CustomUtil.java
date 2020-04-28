package Encrypt;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author tangdongfan
 * @date 2020/4/28 15:31
 * a^b=c
 * a=b^c
 */
public class CustomUtil {
    
    private static final String key = "outside_strategies@author:wdcshwdftdf";

    // 异或加密
    public static String encrypt(String pin){
        byte[] pinBytes = pin.getBytes(StandardCharsets.UTF_8);
        System.out.println("pinBytes长度：" + pinBytes.length + ",pinBytes长度：" + Arrays.toString(pinBytes));
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        /*System.out.println(Arrays.toString(keyBytes));*/
        if (pinBytes.length > keyBytes.length) {
            // 万一pin长度超过key，key填充0至长度相等
            keyBytes = Arrays.copyOf(keyBytes, pinBytes.length);
        }
        for (int i = 0; i < pinBytes.length; i++) {
            pinBytes[i] ^= keyBytes[i];
        }
        System.out.println("密文byte[]：" + Arrays.toString(pinBytes));
        return Base64.getEncoder().encodeToString(pinBytes);
    }

    // 异或解密
    public static String decrypt(String encryptPin){
        byte[] pinBytes = Base64.getDecoder().decode(encryptPin);
        byte[] keyBytes = key.getBytes();
        if (pinBytes.length > keyBytes.length) {
            // 万一pin长度超过key，key填充0至长度相等
            keyBytes = Arrays.copyOf(keyBytes, pinBytes.length);
        }
        for (int i = 0; i < pinBytes.length; i++) {
            pinBytes[i] ^= keyBytes[i];
        }
        return new String(pinBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        String encrypt = encrypt("18201712787_测试asa");
        System.out.println("密文长度：" + encrypt.length() + ",密文：" + encrypt);
        System.out.println("解密后：" + decrypt(encrypt));
    }
}
