package com.longxun.framework.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName HashUtil
 * @Description [一句话描述做什么]
 * @Author linrucheng
 * @Date 2019/12/8 15:42
 * @Version V1.0
 **/
public class HashUtil {
    public static String getSHA(String input) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);

            return null;
        }
    }
}