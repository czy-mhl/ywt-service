package com.yiwei.ywt.framework.utils;



import java.security.MessageDigest;

/**
 * Created by czy on 2017/1/19.
 */
public class EncryptUtils {

    /*public static String md5EncryptAndBase64(String str) {
        return encodeBase64(md5Encrypt(str));
    }*/
    private static byte[] md5Encrypt(String encryptStr) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(encryptStr.getBytes("utf8"));
            return md5.digest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*private static String encodeBase64(byte[] b) {
        BASE64Encoder base64Encode = new BASE64Encoder();
        String str = base64Encode.encode(b);
        return str;
    }*/

}
