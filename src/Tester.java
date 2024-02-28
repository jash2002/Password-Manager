import java.io.*;

/**
 * This class takes user input and can generate a report on their password
 **/

public class Tester {
  String sep = new String();
  String userDirectory;

  
  /**
   * Sets up for use on both Linux and Windows, however doesn't work due to GCC 
   */
  Tester() {
    if (System.getProperty("os.system") == "Windows") {
      sep = "\\";
    } else {
      sep = "/";
    }
    userDirectory = System.getProperty("user.dir");
  }
  
  /** 
   * 
   * @param userInput - user inputted password
   * @return - a string to declare the password strength 
   */
  
   public String check(String userInput) {
    int upper, digit, length, special;
    upper = digit = length = special = 0;

    for (char a : userInput.toCharArray()) {
      length++;
      if (Character.isUpperCase(a)) {
        upper++;
      } else if (Character.isDigit(a)) {
        digit++;
      } else if (!(Character.isDigit(a) || Character.isLetter(a))){
        special++;
      }
    }
    String verdict = new String();
    
    if (length < 5) {
      verdict = "WEAK";
    } else if (length <= 9 && digit >= 2 && special <= 1 && upper <= 2) {
      verdict = "OK";
    } else if (length >= 10 && digit >= 2 && special >= 2 && upper >= 2) {
      verdict = "STRONG";
    } else {
      verdict = "WEAK";
    }
    return verdict;
  }


//Works
/**
 * 
 * @param userInput - User inputted password
 * @return - boolean value if found in file
 * @throws Exception
 */
  public boolean fileInput(String userInput, String fileName) throws Exception {
    
    File passFile = new File(fileName);
    BufferedReader fileRead = new BufferedReader(new FileReader(passFile));
    String st;
    boolean found = false;

    while (( st = fileRead.readLine()) != null) {
    //  System.out.println(st);
      if (st.equals(userInput)) {
        found = true;
        break;
      }
    }
    fileRead.close();
    return found;
  }

  /**
   * 
   * @param userInput
   * @return a boolean array based on if user input is found in the database
   * @throws Exception
   */
  public boolean[] checkExposure(String userInput) throws Exception {

    boolean[] checkExposure = new boolean[3];
    String[] files = {"rockyou.txt", "10-million-password-list-top-1000000.txt", "bt4-password.txt"};
    for (int i = 0; i < 3; i++) {
      checkExposure[i] = fileInput(userInput, userDirectory + sep + "resources" + sep + files[i]);
    } 
      
      return checkExposure;
  } 

/**
 * 
 * @return a string from the embedded C code 
 */
  public String CompileCprog(){

    String result = new String();
    try { 
        Process p = Runtime.getRuntime().exec(userDirectory + sep + "build" + sep + "suggestor");
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
        String line = null;  
        while ((line = in.readLine()) != null) {  
            result += line;  
        }  
    } catch (IOException e) {  
        e.printStackTrace();
    }   
    return result;
  }
}


  
