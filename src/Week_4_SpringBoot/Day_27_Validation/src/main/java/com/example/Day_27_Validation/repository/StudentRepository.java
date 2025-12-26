package com.example.Day_27_Validation.repository;

import com.example.Day_27_Validation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
