package encryptdecrypt.strategy;


import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

/**
 * Crypto using Advance Encryption Standard
 * @author Saruj Sattayanurak
 */
public class AES implements Cipher {
    //AES stand for Advance Encryption Standard
    /**
     * Change normal text in to secret test using AES
     * @param normal or original text
     * @param keys for shift character
     * @return Secret cipher text String
     */
    @Override
    public String encrypt(String originalText, String keys) throws Exception {
        Key key = generateKey(keys);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
        byte[] cipherByte = cipher.doFinal(originalText.getBytes());
        return Base64.getEncoder().encodeToString(cipherByte);
    }

    /**
     * Change cipher text into normal text using AES
     * @param Secret unicode
     * @param keys of character to shift
     * @return normal understandable text
     */
    @Override
    public String decrypt(String cipherText, String keys) throws Exception {
        Key key = generateKey(keys);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
    }

    /**
     * @param key string for generate key
     * @return SecretKey
     */
    private Key generateKey(String key) throws Exception {
        byte[] keys = key.getBytes();
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        keys = Arrays.copyOf(sha.digest(keys), 32);
        SecretKeySpec newKey = new SecretKeySpec(keys, "AES");
        return newKey;
    }
}
