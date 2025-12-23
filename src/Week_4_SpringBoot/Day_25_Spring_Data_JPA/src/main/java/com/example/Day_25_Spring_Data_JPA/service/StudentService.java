package com.example.Day_25_Spring_Data_JPA.service;

import com.example.Day_25_Spring_Data_JPA.model.Student;
import com.example.Day_25_Spring_Data_JPA.repository.StudentRepository;
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
        // This runs "SELECT * FROM students" automatically!
        return studentRepository.findAll();
    }

    // Let's add a save method too
    public Student addStudent(Student student){
        // This runs "INSERT INTO students..."
        return studentRepository.save(student);
    }


}
