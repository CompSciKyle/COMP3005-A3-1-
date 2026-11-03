import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresSQLDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://134.117.134.15:5432/A3(1)";
        String user = "student@localhost.localdomain";
        String password = "A4s6s4u7";
    

        try {
            Class.forName("org.postgresql.Driver");
            //Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Connection successful");
            }
            else{
                System.out.println("Connection failed");

            }

            conn.close();
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

}