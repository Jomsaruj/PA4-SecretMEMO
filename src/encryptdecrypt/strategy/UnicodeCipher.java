package encryptdecrypt.strategy;


/**
 * Crypto using Unicode Strategy
 * @author Saruj Sattayanurak
 */
public class UnicodeCipher implements Cipher {

    /**
     * Change normal text in to secret unicode
     * @param normal or original text
     * @param index for shift character
     * @return Secret unicode String
     */
    @Override
    public String encrypt(String originalText, String index) {
        StringBuilder CipherText = new StringBuilder();
        char CipherChar;
        int keys = Integer.parseInt(index);
        //Encrypt unicode strategy
        for(int i = 0;i < originalText.length();i++){
            char originalChar = originalText.charAt(i);
            CipherChar = (char) (originalChar + keys);
            CipherText.append(CipherChar);
        }
        return CipherText.toString();
    }

    /**
     * Change secret unicode into normal text
     * @param Secret unicode
     * @param index of character to shift
     * @return normal understandable text
     */
    @Override
    public String decrypt(String cipherText, String index) {
        StringBuilder originalText = new StringBuilder();
        char originalChar;
        int keys = Integer.parseInt(index);
        //Decrypt unicode strategy
        for(int i = 0;i < cipherText.length();i++){
            char cipherChar = cipherText.charAt(i);
            originalChar = (char) (cipherChar - keys);
            originalText.append(originalChar);
        }
        return originalText.toString();
    }
}
