import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class upload {

    public static void upLoadToDataBase(String user, String pass, String hashPass) {
        try { 
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "", 
            ""); 
            Statement st = conn.createStatement(); 
            String query = "INSERT INTO creds (userName, passWord, suggestedPass) " + "VALUES (" + "'" + user + "'" + ", " + "'" + pass + "'" + ", " + "'" + hashPass + "'" + ");";
            //INSERT INTO creds (userName, passWord, suggestedPass) VALUES ("username", "pass", "userPass");
            st.executeUpdate(query);
            conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
    }
}

