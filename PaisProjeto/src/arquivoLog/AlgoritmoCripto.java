package arquivoLog;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AlgoritmoCripto {

	public String cryptoMD5(String senha) throws NoSuchAlgorithmException,
	UnsupportedEncodingException {
		
		MessageDigest algoritmoCrypto = MessageDigest.getInstance("MD5");
		byte cryptoMD5[] = algoritmoCrypto.digest(senha.getBytes("UTF-8"));
		
		StringBuilder hex = new StringBuilder();
		
		for(byte x: cryptoMD5) hex.append(String.format("%02X", 0xFF & x));
		
		String sHex = hex.toString();
		
		return sHex;
	}
	
	public String cryptoSHA(String senha) throws NoSuchAlgorithmException,
	UnsupportedEncodingException {
		
		MessageDigest algoritmoCrypto = MessageDigest.getInstance("SHA-256");
		byte cryptoSHA[] = algoritmoCrypto.digest(senha.getBytes("UTF-8"));
		
		StringBuilder hex = new StringBuilder();
		
		for(byte x: cryptoSHA) hex.append(String.format("%02X", 0xFF & x));
		
		String sHex = hex.toString();
		
		return sHex;	
	}
	
	public String cryptoSHAHex(String senha) throws NoSuchAlgorithmException,
	UnsupportedEncodingException {
		
		MessageDigest algoritmoCrypto = MessageDigest.getInstance("SHA-256");
		byte cryptoSHAHEX[] = algoritmoCrypto.digest(senha.getBytes("UTF-8"));
		
		StringBuilder hex = new StringBuilder();
		
		for(byte x: cryptoSHAHEX) hex.append(String.format("%02X", 0xFF & x));
		
		String sHex = hex.toString();
		
		return sHex;
		
	}
}