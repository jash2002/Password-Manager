
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    /**
     * 
     * @param userInput
     * @return a hash which is encrypted via a Caesar cipher 
     */
    
    public static String getHash(String userInput) {
        
        try {
        
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageArray = md.digest(userInput.getBytes());
            BigInteger numb = new BigInteger(1, messageArray);
            String hashtext = numb.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return CaesarEncrypt(hashtext, 34);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static String CaesarEncrypt(String ciphertext, int shift) {
        return Caesar.rotate(shift, ciphertext);
    } 
}
