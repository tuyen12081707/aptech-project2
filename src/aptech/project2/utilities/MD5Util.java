/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String encrypt(String input) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String Decrypt(String md5_hash) throws Exception {

        String api_key = "YOUR_VIP_KEY";
        URL md5online = new URL("https://www.md5online.org/api.php?d=1&p=" + api_key + "&h=" + md5_hash);
        BufferedReader in = new BufferedReader(new InputStreamReader(md5online.openStream()));

        String result = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result = result + inputLine;
        }
        in.close();

        return result;
    }

    public static void main(String[] args) {
        String input = "123";
        String encrypt = MD5Util.encrypt(input);
        System.out.println("Password encrypt: " + encrypt);
    }
}
