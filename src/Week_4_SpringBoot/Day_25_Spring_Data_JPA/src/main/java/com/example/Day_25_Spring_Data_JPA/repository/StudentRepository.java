package com.example.Day_25_Spring_Data_JPA.repository;

import com.example.Day_25_Spring_Data_JPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// MAGIC HAPPENS HERE
// We extend JpaRepository<Type, ID_Type>
// Spring automatically generates methods like findAll(), save(), deleteById()
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    // No code needed. Seriously.
}
