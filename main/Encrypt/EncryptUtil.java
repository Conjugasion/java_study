package Encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tangdongfan
 * @date 2020/4/23 18:45
 * 基于非对称算法RSA加密/解密用户Pin
 * 公钥加密，私钥解密
 */
public class EncryptUtil {

    public static final Key PUBLIC_KEY;
    public static final Key PRIVATE_KEY;

    // 生成公钥和私钥
    static {
        //KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //初始化密钥对生成器，密钥大小512以上
        keyPairGen.initialize(512);
        //生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        //得到私钥
        PRIVATE_KEY = keyPair.getPrivate();
        //得到公钥
        PUBLIC_KEY = keyPair.getPublic();
    }

    // 加密算法
    public static String encrypt(String srcMsg) {
        try {
            byte[] srcMsgByte = srcMsg.getBytes();
            //Cipher基于RSA进行加密
            Cipher cipher = Cipher.getInstance("RSA");
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.ENCRYPT_MODE, PUBLIC_KEY);
            byte[] encryptMsgByte = cipher.doFinal(srcMsgByte);
            return new BASE64Encoder().encode(encryptMsgByte).replaceAll("[\\s*\t\n\r]", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 解密算法
    public static String decrypt(String encryptMsg) {
        try {
            byte[] encryptMsgByte = new BASE64Decoder().decodeBuffer(encryptMsg);
            //Cipher基于RSA进行解密
            Cipher cipher = Cipher.getInstance("RSA");
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.DECRYPT_MODE, PRIVATE_KEY);
            byte[] srcMsgByte = cipher.doFinal(encryptMsgByte);
            return new String(srcMsgByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String srcMsg = "123asdas123asdddddddddddd";
        String encrypt = encrypt(srcMsg);
        String decrypt = decrypt(encrypt);
        System.out.println("密文：" + encrypt);
        System.out.println("密文长度：" + encrypt.length());
        System.out.println("解密后：" + decrypt);
    }
}
