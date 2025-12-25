package com.example.Day_26_POST_Request.repository;

import com.example.Day_26_POST_Request.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
