package encryptdecrypt;


import encryptdecrypt.strategy.*;
import java.io.*;

/**
 * create a .txt file which contain cipher text.
 * children class of FileHandler
 * @author Saruj Sattayanurak
 */
public class WriteFile extends FileHandler{
    /**
     * create a new .txt file which contain cipher text
     * @param message to write on the file
     * @param dest destination to save file
     * @param key key of encryption
     * @return boolean true if create file successful and return false if not
     */
    public boolean writeFile(String message, String dest, String key, String strategy) throws Exception {
        File destFile = new File(dest);
        if (destFile.exists()) { error("Destination already exists, not overwriting it.");return false; }
        if (!destFile.exists()){
            if(isValid(key,strategy)) {
                try (FileWriter out = new FileWriter(destFile);) {
                    Cipher enc = new AlphabetShiftCipher();
                    if (strategy.equals("s2"))  enc = new UnicodeCipher();
                    if (strategy.equals("s3")) enc = new KeyWordCipher();
                    if(strategy.equals("s4")) enc = new AES();
                    String text = enc.encrypt(message, key);
                    out.write(text);
                }
                catch (IOException ioe) { error(ioe.getMessage());return false; }
            }
            else return false;
        }
        return true;
    }
}
