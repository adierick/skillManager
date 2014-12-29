 
package com.springmvc.utils;
 
import java.io.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import java.security.Key; 

import javax.crypto.Cipher; 
import javax.crypto.spec.SecretKeySpec; 
 
public class EncryptDecrypt {
  
  private String algo = "Blowfish";
 
  private static EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
  
  public static EncryptDecrypt getInstance() {
		return encryptDecrypt;
	}
  public String crypter(String password, String entree) {
    try {
      byte[] passwordInBytes = password.getBytes("ISO-8859-1"); 
      Key clef = new SecretKeySpec(passwordInBytes, algo); 
      Cipher cipher = Cipher.getInstance(algo);
      cipher.init(Cipher.ENCRYPT_MODE, clef);
 
      byte[] texteClaire = entree.getBytes();
      byte[] texteCrypte = cipher.doFinal(texteClaire);

      String sortie = texteCrypte.toString();
      
      return sortie;
    }
    catch (Exception e) {
      return "Erreur";
    }
  }
 
  public String decrypter(String password, String entree) {
    try {
      byte[] passwordInBytes = password.getBytes("ISO-8859-1"); 
      Key clef = new SecretKeySpec(passwordInBytes, algo); 
      Cipher cipher = Cipher.getInstance(algo);
      cipher.init(Cipher.DECRYPT_MODE, clef);
 
      byte[] texteCrypte = entree.getBytes();
      byte[] texteClaire = cipher.doFinal(texteCrypte);

      String sortie = texteClaire.toString();
     
      return sortie;
    }
    catch (Exception e) {
      return "Erreur";
    }
  }
 
 
}