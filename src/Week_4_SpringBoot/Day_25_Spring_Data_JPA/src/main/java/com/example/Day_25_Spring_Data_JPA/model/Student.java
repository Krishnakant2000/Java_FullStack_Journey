package com.example.Day_25_Spring_Data_JPA.model;

import jakarta.persistence.*;

@Entity // 1. Tells Spring this is a Database Table
@Table(name = "students") // 2. Specifies the table name
public class Student {

    @Id // 3. Primary Key
   @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Auto Increment
    private Long id;

    private String name;
    private int age;
    private double grade;

    // JPA requires an Empty Constructor
    public Student() {
    }
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters (Important!)
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

}
