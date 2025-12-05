package Week_2_OOP_Deep_Dive.Day_14_Capstone_SMS;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class SMSApp {
    static void main() {

        StudentManager studentManager = new StudentManager();
        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running) {
           try {
               System.out.println("\n1. Add Student | 2. View All | 3. Search | 4. Average | 5. Exit");
               System.out.print("Enter your choice: ");
               int choice = input.nextInt();
               input.nextLine();

               switch (choice) {
                   case 1:

                       System.out.print("Enter Student Name: ");
                       String studentName = input.nextLine();

                       // Validation Logic
                       System.out.print("Enter Grade (0-100): ");
                       double grade = input.nextDouble();

                       System.out.print("Enter Student Age: ");
                       int studentAge = input.nextInt();

                       if (studentAge < 0 ||  grade < 0 || grade > 100) {
                           System.out.println("Error: Invalid Age or Grade.");
                       } else {
                           String studentId = UUID.randomUUID().toString().substring(0,8);
                           studentManager.addStudent(studentId, studentName, studentAge, grade);
                       }
                       break;
                   case 2:
                       studentManager.viewAllStudents();
                       break;
                   case 3:
                       System.out.println("Enter Student Name to search: ");
                       String keyword = input.nextLine();
                       studentManager.searchStudentByName(keyword);
                       break;
                   case 4:
                       studentManager.showClassAverage();
                       break;
                   case 5:
                       System.out.println("Goodbye!");
                       running = false;
                       break;
                   default:
                       System.out.println("Invalid choice.");
                       break;
               }
           } catch (InputMismatchException e) {
               System.out.println("Error: Please enter a valid number!");
               input.nextLine();
           }

        }
        input.close();
    }
}
