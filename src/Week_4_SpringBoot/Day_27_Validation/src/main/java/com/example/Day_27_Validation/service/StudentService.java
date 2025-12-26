package com.example.Day_27_Validation.service;

import com.example.Day_27_Validation.model.Student;
import com.example.Day_27_Validation.repository.StudentRepository;
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

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        // 1. Check if student exists in DB
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            // 2. Update the fields
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setGrade(student.getGrade());

            // 3. Save (Repository is smart: if ID exists, it updates instead of inserting)
            return studentRepository.save(existingStudent);
        }

        return null;
    }

}
