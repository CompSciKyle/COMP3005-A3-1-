package src.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class student_service{
    public static void getAllStudents(){
        
        String sql = "SELECT * FROM students";
        try (
            Connection conn = PostgresSQLDBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){

            System.out.printf("%-5s %-15s %-15s %-30s %-15s%n","ID", "First Name", "Last Name", "Email", "Enrollment Date");
            System.out.println("--------------------------------------------------------------------------");
            while(rs.next()){
                int id = rs.getInt("student_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name"); 
                String email = rs.getString("email");
                String date = rs.getString("enrollment_date");
                
                System.out.printf("%-5d %-15s %-15s %-30s %-15s%n", id, first, last, email, date);            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Try with automatically closes the connection
    }

    public static void addStudent(String first_name, String last_name, String email, String enrollment_date){
        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES(?,?,?,?)";
        try (
            Connection conn = PostgresSQLDBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertSQL))
        {
            pstmt.setString(1,first_name);
            pstmt.setString(2,last_name);
            pstmt.setString(3,email);
            pstmt.setDate(4,java.sql.Date.valueOf(enrollment_date));
            pstmt.executeUpdate();


            System.out.printf("Data inserted" );
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateStudentEmail(Integer student_id,String new_email){
        String sql = "UPDATE students SET email = ? WHERE student_id = ?";

        try (
            Connection conn = PostgresSQLDBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Email updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void deleteStudent(Integer student_id){
        String deleteSQL = "DELETE FROM students WHERE student_id = " + student_id;

        try (
            Connection conn = PostgresSQLDBConnection.getConnection();
            Statement stmt = conn.createStatement();
        ){
            stmt.executeUpdate(deleteSQL);

            System.out.printf("Delete was successful");
        

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}