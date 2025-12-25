package com.example.Day_26_POST_Request.service;

import com.example.Day_26_POST_Request.model.Student;
import com.example.Day_26_POST_Request.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    // Let's complete this now
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
}
