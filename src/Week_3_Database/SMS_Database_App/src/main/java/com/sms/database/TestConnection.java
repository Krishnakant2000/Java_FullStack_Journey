package com.sms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
    static void main() {
        // 1. Database Credentials
        // "jdbc:mysql://" is the protocol
        // "localhost:3306" is the server address
        // "fullstack_db" is the database name
        String url = "jdbc:mysql://localhost:3306/fullstack_db";
        String username = "your username ";
        String password = "your password ";

        System.out.println("Connecting to database...");

        // 2. Try-With-Resources Block
        // This is a special try block that AUTOMATICALLY closes the connection
        // when done. No need for a "finally" block!
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connection Successful!");

            // 3. Create a Statement
            Statement statement = connection.createStatement();

            // 4. Execute Query
            String sql = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(sql);

            // 5. Process Results
            System.out.println("\n--- Student List ---");

            // .next() moves the cursor to the next row.
            // It returns false when there are no more rows.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double grade = resultSet.getDouble("grade");

                System.out.println("ID: " + id + " | Name: " + name + " | Grade: " + grade);
            }

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }

    }
}
