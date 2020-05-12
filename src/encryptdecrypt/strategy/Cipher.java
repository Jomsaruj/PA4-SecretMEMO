package encryptdecrypt.strategy;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/**
 * An interface for crypto
 * @author Saruj Sattayanurak
 */
public interface Cipher {
    /**
     * Change normal understandable into secret code
     * @param normal or original text
     * @param keys to shift the character
     * @return Secret code
     */
    String encrypt(String originalText, String keys) throws Exception;
    /**
     * Convert the Cipher text in to normal text.
     * @param cipherText that want to turn back to originalText
     * @param keys for shift the character
     * @return readable message
     */
    String decrypt(String cipherText , String keys) throws Exception;
}
