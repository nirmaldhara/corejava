package com.javaant;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CipherUtils {

	private static byte[] key = { 0x24, 0x68, 0x78, 0x71, 0x49, 0x73, 0x41,
		0x24, 0x28, 0x78, 0x41, 0x49, 0x63, 0x41,0x73, 0x9};// "this Is A SecretKey you can change it, size is 16";

	public static String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			final String encryptedString = Base64.encodeBase64String(cipher
					.doFinal(strToEncrypt.getBytes()));
			return encryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
			return decryptedString;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public static String getEncryptedString(String str) {
		final String strToEncrypt = str;
		final String encryptedStr = CipherUtils.encrypt(strToEncrypt.trim());

		return encryptedStr;
	}

	public static String getDecriyptedString(String str) {
		final String strToDecrypt = str;
		final String decryptedStr = CipherUtils.decrypt(strToDecrypt.trim());

		return decryptedStr;
	}

	
}



