package com.example.Day_27_Validation.controller;

import com.example.Day_27_Validation.model.Student;
import com.example.Day_27_Validation.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public Student saveStudent(@Valid @RequestBody Student student) {// @Valid triggers the rules!
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Student student) {// @Valid triggers the rules!
        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);// Return 200 OK
        } else  {
            return ResponseEntity.notFound().build();// Return 404 Not Found
        }
    }

}
