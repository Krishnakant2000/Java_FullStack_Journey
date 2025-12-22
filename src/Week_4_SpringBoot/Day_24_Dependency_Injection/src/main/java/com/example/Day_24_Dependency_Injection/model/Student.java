package com.example.Day_24_Dependency_Injection.model;

public class Student {

    private String name;
    private String role;

    public Student(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public String getRole() { return role; }

}
