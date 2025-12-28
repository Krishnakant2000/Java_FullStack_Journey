package com.example.Day_28_Exception_Handling.repository;

import com.example.Day_28_Exception_Handling.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
