package com.sms.database;

public class DAORunner {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Adding a new student is now just ONE line of code
        studentDAO.addStudent("Black Widow", 35, 98.5);
        studentDAO.addStudent("Hawkeye", 38, 85.0);
    }
}
