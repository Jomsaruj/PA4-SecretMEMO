package encryptdecrypt.strategy;


/**
 * Crypto using Keyword Strategy
 * @author Saruj Sattayanurak
 */
public class KeyWordCipher implements Cipher {

    /**
     * Change normal text in to secret test using keyword
     * @param normal or original text
     * @param keys for shift character
     * @return Secret cipher text String
     */
    @Override
    public String encrypt(String originalText, String keys) {
        StringBuilder CipherText = new StringBuilder();
        char CipherChar;
        int keyIndex = 0;
        for(int i = 0;i < originalText.length();i++){
            if(keyIndex == keys.length()) keyIndex = 0;
            char originalChar = originalText.charAt(i);
            CipherChar = (char) (originalChar + keys.charAt(keyIndex));
            keyIndex++;
            CipherText.append(CipherChar);
        }
        return CipherText.toString();
    }

    /**
     * Change cipher text into normal text
     * @param Secret unicode
     * @param keys of character to shift
     * @return normal understandable text
     */
    @Override
    public String decrypt(String cipherText, String keys) {
        StringBuilder originalText = new StringBuilder();
        char originalChar;
        int keyIndex = 0;
        for(int i = 0;i < cipherText.length();i++){
            if(keyIndex == keys.length()) keyIndex = 0;
            char cipherChar = cipherText.charAt(i);
            originalChar = (char) (cipherChar - keys.charAt(keyIndex));
            keyIndex++;
            originalText.append(originalChar);
        }
        return originalText.toString();
    }
}
