package com.sms.database;

import java.util.List;

public class DAORunner {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        // 1. Insert a test student
        System.out.println("--- 1. Adding Data ---");
        studentDAO.addStudent("Bryce Wayne", 40, 99.9);

         // 2. Read all data
        System.out.println("--- 2. Reading Data ---");
        List<Student> allStudents = studentDAO.getAllStudents();

        // Using the Stream forEach learned in Week 2!
        allStudents.forEach(System.out::println);

        // 3. Delete the student we just added
        // (You'll need to look at the ID from the printout above to know which ID to delete)
        System.out.println("\n--- 3. Deleting Data ---");
        studentDAO.deleteStudent(9);

        // 4. Verify Deletion
        System.out.println("\n--- 4. Updated List ---");
        studentDAO.getAllStudents().forEach(System.out::println);

        // 5. Update student
        System.out.println("\n--- 5. Updating Data ---");
        Student student = new Student(10, "Bryce Wayne", 42, 99.99);
        studentDAO.updateStudent(student);


        // 6. Verify Updating Students
        System.out.println("\n--- 6. Updated List ---");
        studentDAO.getAllStudents().forEach(System.out::println);

    }
}
