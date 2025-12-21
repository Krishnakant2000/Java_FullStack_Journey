package com.example.Day_23_REST_Controllers.controller;

import com.example.Day_23_REST_Controllers.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students") // Base URL for everything in this class
public class StudentController {

    // 1. Return a Single Object -> Becomes JSON Object
    @GetMapping("/leader")
    public Student getLeader(){
        // We return a Java Object...
        return new Student("Iron Man", "Leader");
        // Spring automatically sends: {"name":"Iron Man", "role":"Leader"}
    }

    // 2. Return a List -> Becomes JSON Array
    @GetMapping("/all")
    public List<Student> getAll(){
        List<Student> team = new ArrayList<>();
        team.add(new Student("Thor", "Muscle"));
        team.add(new Student("Spiderman", "Rookie"));
        return team;
        // Output: [{"name":"Thor"...}, {"name":"Spiderman"...}]
    }

    // 3. Dynamic URL (Path Variables)
    // URL: localhost:8080/students/find/Hulk
    @GetMapping("/find/{name}")
    public Student findStudent(@PathVariable String name){
        return new Student(name, "Unknown Role");
    }

}
