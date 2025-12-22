package com.example.Day_24_Dependency_Injection.controller;

import com.example.Day_24_Dependency_Injection.model.Student;
import com.example.Day_24_Dependency_Injection.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // 2. We declare the variable, but we DO NOT say "= new StudentService()".
    private final StudentService studentService;

    // 3. Constructor Injection (The Best Practice)
    // Spring sees this constructor and says:
    // "Aha! He needs a StudentService. I have one ready. I'll plug it in."
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
