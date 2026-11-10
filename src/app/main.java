package src.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;


public class main {

    public static void main(String[] args) {
        int userInput = 1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(userInput != 5){

            userInterface();
            System.out.println("Enter your choice: ");
            try {
                
                userInput = Integer.parseInt(reader.readLine());
                switch (userInput) {
                    case 1:
                        student_service.getAllStudents();
                        break;
                    case 2:
                        {
                            System.out.println("What is the first name of the student");
                            String first_name = reader.readLine();
                            System.out.println("What is the last name of the student");
                            String last_name = reader.readLine();
                            System.out.println("What is the email of the student");
                            String email = reader.readLine();
                            student_service.addStudent(first_name,last_name,email,LocalDate.now().toString());
                            break;
                        }
                    case 3:
                        {
                            System.out.println("What is the id of the student you want to update");
                            int id = Integer.parseInt(reader.readLine());
                            System.out.println("What is the email of the student");
                            String email = reader.readLine();
                            student_service.updateStudentEmail(id, email);
                            break;
                        }
                    case 4:
                        {
                            System.out.println("What is the id of the student you want to delete");
                            int id = Integer.parseInt(reader.readLine());
                            student_service.deleteStudent(id);
                            break;
                        }
                        case 5:
                            System.out.println("Goodbye");
                            break;
                    default:
                        System.out.println("Not a valid command");
                        break;
                }
             } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static void userInterface(){
        System.out.println("Run your commands");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1. Get all students");
        System.out.println("2. Add a student using a first_name, a last_name, a email and a enrollment_date");
        System.out.println("3. Update student email using a id followed by a email");
        System.out.println("4. Delete a student using their id");
        System.out.println("5. Quit");
    }
}

