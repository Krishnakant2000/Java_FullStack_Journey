package com.sms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    private String url = "jdbc:mysql://localhost:3306/fullstack_db";
    private String username = "your username";
    private String password = "your password";

    public  void addStudent(String name, int age, double grade) {

        String query = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setDouble(3, grade);

            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Success! Added student: " + name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
