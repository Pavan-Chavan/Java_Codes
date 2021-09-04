/* Title: Java MD5
coder:Pavan Chavan
date: 29/8/21 */

import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        byte[] digest = md.digest();
        for (byte b : digest) {
            System.out.format("%02x", b);
        }
    }
}
