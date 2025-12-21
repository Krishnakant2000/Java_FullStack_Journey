package com.example.Day_23_REST_Controllers.model;

//In standard Java, you have Objects (new Student("Tony")). In the Browser, you need JSON ({"name": "Tony"}).
// Spring Boot automatically converts your Java Objects into JSON. You don't have to do anything!

public class Student {

    private String name;
    private String role;

    public Student(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // GETTERS ARE MANDATORY FOR JSON!
    // If you forget getters, the JSON will be empty {}.
    public String getName() { return name; }
    public String getRole() { return role; }

}
