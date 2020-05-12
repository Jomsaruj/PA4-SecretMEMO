package encryptdecrypt.strategy;


/**
 * Crypto using AlphabetShift Strategy
 * @author Saruj Sattayanurak
 */
public class AlphabetShiftCipher implements Cipher {

    /**
     * Change normal understandable text into secret text using AlphabetShift Strategy.
     * @param normal or original text
     * @param index to shift the character
     * @return Secret code String
     */
    @Override
    public String encrypt(String originalText, String index) {
        StringBuilder CipherText = new StringBuilder();
        char CipherChar = (char)0;
        int keys = Integer.parseInt(index);
        for(int i = 0;i < originalText.length();i++){
            char originalChar = originalText.charAt(i);
            if (Character.isLetter(originalChar)){
                if(Character.isLowerCase(originalChar)){
                    CipherChar = (char) (originalChar + keys);
                    if (CipherChar > 'z'){
                        CipherChar = (char)('a' + ((CipherChar - 1) - 'z'));
                    }
                }
                else if(Character.isUpperCase(originalChar)){
                    CipherChar = (char) (originalChar + keys);
                    if (CipherChar > 'Z'){
                        CipherChar = (char)('A' + ((CipherChar - 1) - 'Z'));
                    }
                }
                CipherText.append(CipherChar);
            }
            else {
                CipherText.append(originalChar);
            }
        }
        return CipherText.toString();
    }

    /**
     * Convert the Cipher text in to normal text using AlphabetShift Strategy.
     * @param cipherText that want to turn back to originalText
     * @param index for shift the character
     * @return readable String
     */
    @Override
    public String decrypt(String cipherText, String index) {
        StringBuilder originalText = new StringBuilder();
        char originalChar = (char)0;
        int keys = Integer.parseInt(index);
        //Decrypt algorithm
        for(int i = 0;i < cipherText.length();i++){
            char cipherChar = cipherText.charAt(i);
            if (Character.isLetter(cipherChar)){
                if(Character.isLowerCase(cipherChar)){
                    originalChar = (char) (cipherChar - keys);
                    if (originalChar < 'a'){
                        originalChar = (char)('z' - ('a' - (originalChar+1)));
                    }
                }
                else if(Character.isUpperCase(cipherChar)){
                    originalChar = (char) (cipherChar - keys);
                    if (originalChar < 'A'){
                        originalChar = (char)('Z' - ('A' - (originalChar+1)));
                    }
                }
                originalText.append(originalChar);
            }
            else{
                originalText.append(cipherChar);
            }
        }
        return originalText.toString();
    }
}
