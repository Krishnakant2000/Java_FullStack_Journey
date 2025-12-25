package com.example.Day_26_POST_Request.controller;

import com.example.Day_26_POST_Request.model.Student;
import com.example.Day_26_POST_Request.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // 1. Map POST requests to the same URL
    @PostMapping
    // 2. @RequestBody takes the JSON coming in and turns it into a 'Student' object
    public Student saveStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
