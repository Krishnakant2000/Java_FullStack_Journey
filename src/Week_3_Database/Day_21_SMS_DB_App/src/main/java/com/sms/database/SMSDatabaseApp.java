package com.sms.database;

import java.util.List;
import java.util.Scanner;

public class SMSDatabaseApp {
    static void main() {

        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        boolean running = true;
        System.out.println("=== DB-Powered Student Management System ===");

        while (running) {
            System.out.println("\n1. Add Student | 2. View All | 3. Update | 4. Delete | 5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Fix newline bug

            switch (choice) {
                case 1: // CREATE
                    System.out.println("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Student Age: ");
                    int age = sc.nextInt();
                    System.out.println("Enter Student Grade: ");
                    double grade = sc.nextDouble();
                    studentDAO.addStudent(name, age, grade);
                    break;
                case 2: // READ
                    List<Student> students = studentDAO.getAllStudents();
                    if(students.isEmpty()) {
                        System.out.println("There are no students in the database");
                    } else  {
                        System.out.println("--- Student List ---");
                        // Using Lambda to print nicely
                        students.forEach(System.out::println);
                    }
                    break;
                case 3: // UPDATE
                    System.out.println("Enter Student Id to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Name: ");
                    String newName = sc.nextLine();
                    System.out.println("Enter Student Age: ");
                    int newAge = sc.nextInt();
                    System.out.println("Enter Student Grade: ");
                    double newGrade = sc.nextDouble();

                    // Create the object to pass to your new method
                    Student updatedStudent = new Student(updateId, newName, newAge, newGrade);
                    studentDAO.updateStudent(updatedStudent);
                    break;
                case 4:// DELETE
                    System.out.println("Enter Student Id to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    studentDAO.deleteStudent(deleteId);
                    break;
                case 5: // EXIT
                    System.out.println("Goodbye! Data is safe in MySQL.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");

            }

        }
        sc.close();
    }
}
