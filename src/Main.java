import java.util.*;

public class Main { 

  /**
   * Driver which runs the project 
   */

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws Exception {
    System.out.println("--- PASSWORD AUDIT AND MANAGER ---");
    System.out.println("""
        MENU: 
        1. Checker 
        2. Suggestor 
        3. Exit and Save
        """);

    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a username");
    String user = scan.next();
    System.out.println("Please enter your password");
    String userInput = scan.next();
    
    
    Tester test = new Tester();
    int input = 0;  
    boolean[] array = test.checkExposure(userInput);
    String result = test.CompileCprog();



    while(true) {
      try {
        System.out.println("Please enter your choice");
        input = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please try again");
      } if (input == 1) {
          if (test.check(userInput).equals("strong")) {
            System.out.println(ANSI_GREEN_BACKGROUND + test.check(userInput) + ANSI_RESET);
          } else if (test.check(userInput).equals("ok")) {
            System.out.println(ANSI_YELLOW_BACKGROUND + test.check(userInput) + ANSI_RESET);
          } else {
            System.out.println(ANSI_RED_BACKGROUND + test.check(userInput) + ANSI_RESET);
          }
      } else if (input == 2) {
        System.out.println(result);
      } else {
        break;
      }
    } try {

      System.out.println("\n\b----- OUTPUT -------");
      System.out.println("\nIs it found in rockyou Database: " + array[0]);
      System.out.println("\nIs it found in  Crackstation Database: " + array[1]);
      System.out.println("\nIs it found in Nato Common Passwords Database: " + array[2] + "\n");
      
      System.out.println("Both the username and password supplied will be saved inside a database");
      upload.upLoadToDataBase(user, Encryptor.getHash(userInput), result);
    } catch (Exception a) {
      System.out.println("error: please run again");
    } 
    scan.close();
  }
}  