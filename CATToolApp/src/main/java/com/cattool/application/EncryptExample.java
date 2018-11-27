package com.cattool.application;

import java.security.MessageDigest;

import com.cattool.application.encryption.EncryptPassword;

//public class EncryptExample {
//    public static void main(String[] args) {
//        String password = "priyanjali";
//        String algorithm = "SHA";
//
//        byte[] plainText = password.getBytes();
//
//        try {
//            MessageDigest md = MessageDigest.getInstance(algorithm);
//
//            md.reset();
//            md.update(plainText);
//            byte[] encodedPassword = md.digest();
//
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < encodedPassword.length; i++) {
//                if ((encodedPassword[i] & 0xff) < 0x10) {
//                    sb.append("0");
//                }
//
//                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
//            }
//
//            System.out.println("Plain    : " + password);
//            System.out.println("Encrypted: " + sb.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }}

public class EncryptExample {

    public static void main(String[] args) {
    	
String str1 = "Tomcat 7.0.0 and above";
		
		//System.out.println(str1.contains("\\")); //true
		//System.out.println(str1.contains("/")); //true
		
		boolean flag = "above".contains("Tomcat 7.0.0 and above"); //false
		System.out.println(flag);
//        try {
//        String password = "priyanjali";
//            System.out.println("plain pass="+password);
//        String encryptedPassword = EncryptPassword.encrypt(password);
//            System.out.println("encrypted pass="+encryptedPassword);
//        String decryptedPassword = EncryptPassword.decrypt(encryptedPassword);    
//                System.out.println("decrypted pass="+decryptedPassword);
//        } catch(Exception e) { System.out.println("bug"+e.getMessage()); }
    }
    
}
