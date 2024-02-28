
/**
 * Constructs a class called Caesar where there are two variables used to implement a caesar cipher.
 */

public class Caesar 
{
    /**
     *@param shift
     *@param rotate. These are imported from the main function which are entered by the user, this method allows the chracter to be
     *rotated by a shift which is declared by the user
     *@return encryptedChar allows for the char to be pritninted in main
     */

    public static char rotate(int shift, char rotate) 
    {
        char encryptedChar = ' ';

        if (rotate >= 'a' && rotate <= 'z') {
            encryptedChar = (char) ((rotate - 'a' + shift % 26 + 26) % 26 + 'a');
        }
        else if (rotate >= 'A' && rotate <= 'Z') {
            encryptedChar =  (char) ((rotate - 'A' + shift % 26 + 26) % 26 + 'A');
        } else {
            encryptedChar = rotate;
        }
        //System.out.println(encryptedChar);
        return encryptedChar;
    }


    /**
     *@param shift,
     *@param phrase. These are "imported" from the main method where the user has selected their values
     * This method allows to shift to string by the shift which results in an encrypted message
     *@return encrypted, returns the value which is then printed in mian
     *
     */
    public static String rotate(int shift, String phrase) 
    {
        String encrypted = new String(); // Blank string as a template
        for (int i = 0; i < phrase.length(); i++) 
        {
          encrypted += rotate(shift, phrase.charAt(i));
        }
        return encrypted;
    }

    /**
     *
     * @param args String[], there parameters are: shift, which is used as they key for the cipher and phrase, which is used
     *              to enter the string.
     *
     * This main method is used to call the other method called rotate, this is then used to print out the string
     * which has been rotated.
     * To use this program you must specify the integer to shift by and the phrase to shift, in that order.
     */

    // public static void main(String[] args) 
    // {
    //     Caesar c = new Caesar();
    //     if (args.length > 2) {
    //         System.out.println("Too many parameters! \nUsage: java Caesar n \"cipher text\"");
    //         return;
    //     } else if (args.length < 2) {
    //         System.out.println("Too few parameters!\nUsage: java Caesar n \"cipher text\"");
    //         return;
    //     }

    //     if (args.length == 2)
    //     {
    //         String encrypted = c.rotate(Integer.parseInt(args[0]), args[1]);
    //         System.out.println(encrypted);
    //     }


    // }
}






