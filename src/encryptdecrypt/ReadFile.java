package encryptdecrypt;


import encryptdecrypt.strategy.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * read a .txt file which contain cipher text.
 * Children class of FileHandler
 * @author Saruj Sattayanurak
 */
public class ReadFile extends FileHandler{
    /**
     * read a new .txt file which contain cipher text
     * @param source source file to read and decrypt
     * @param key key for decryption
     * @return boolean true if read file successful and return false if not
     */
    public String readFile(String source, String key, String strategy) throws Exception{
        // check file status
        File fs = new File(source);
        if(!fs.exists()||!fs.isFile()) {error("File is not a regular file"); return null;}
        if(!fs.canRead()) {error("File is unreadable"); return null;}
        // File decryption
        StringBuilder text = new StringBuilder();
        if(isValid(key, strategy)) {
            try {
                Cipher dec = new AlphabetShiftCipher();
                if (strategy.equals("s2")) dec = new UnicodeCipher();
                if (strategy.equals("s3")) dec = new KeyWordCipher();
                if(strategy.equals("s4")) dec = new AES();
                Scanner in = new Scanner(fs);
                String line;
                while (in.hasNext()) {
                    line = in.nextLine();
                    text.append(dec.decrypt(line, key));
                }
            } catch (IOException ioe) { error(ioe.getMessage());return null; }

        }
        return text.toString();
    }
}
