package Encrypt;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tangdongfan
 * @date 2020/4/23 18:45
 * 基于非对称算法RSA加密/解密用户Pin
 * 公钥加密，私钥解密
 */
public class EncryptUtil {

    public static final String PRIVATE_KEY = "privateKey";
    public static final String PUBLIC_KEY = "publicKey";

    // 生成公钥和私钥
    public static Map<String, Key> generatorKeys() {
        try {
            Map<String,Key> keys = new HashMap<>();
            //KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            //初始化密钥对生成器，密钥大小为1024位
            keyPairGen.initialize(1024);
            //生成一个密钥对，保存在keyPair中
            KeyPair keyPair = keyPairGen.generateKeyPair();
            //得到私钥
            Key privateKey = keyPair.getPrivate();
            //得到公钥
            Key publicKey = keyPair.getPublic();
            keys.put(PRIVATE_KEY, privateKey);
            keys.put(PUBLIC_KEY, publicKey);
            return keys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 加密算法
    public static byte[] encrypt(Key publicKey, String srcMsg) {
        try {
            byte[] srcMsgByte = srcMsg.getBytes();
            //Cipher基于RSA进行加密
            Cipher cipher = Cipher.getInstance("RSA");
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            //加密
            return cipher.doFinal(srcMsgByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 解密算法
    public static String decrypt(Key privateKey, byte[] encryptMsgByte) {
        try {
            //Cipher基于RSA进行解密
            Cipher cipher = Cipher.getInstance("RSA");
            //根据公钥，对Cipher对象进行初始化
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            //解密
            byte[] srcMsgByte = cipher.doFinal(encryptMsgByte);
            return new String(srcMsgByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
