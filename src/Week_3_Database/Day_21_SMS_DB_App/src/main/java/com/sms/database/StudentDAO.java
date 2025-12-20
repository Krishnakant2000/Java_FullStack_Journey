package com.sms.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {


    private String url = "jdbc:mysql://localhost:3306/fullstack_db";
    private String username = "your username";
    private String password = "your password";

    // Feature 1: Add Student (CREATE)
    public void addStudent(String name, int age, double grade) {

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

    // FEATURE 2: Get All Students (READ)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                // Map DB Columns to Java variables
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double grade = resultSet.getDouble("grade");

                students.add(new Student(id, name, age, grade));

            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return students;
    }

    // Feature 3: Update Student (UPDATE)
    public void updateStudent(Student student) {

        String query = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setDouble(3, student.getGrade());
            stmt.setInt(4, student.getId());

            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Success! Updated student with Id: " + student.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // FEATURE 4: Delete Student (DELETE)
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0) {
                System.out.println("Success! Deleted Student ID: " + id);
            }else {
                System.out.println("Error: Student ID " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
