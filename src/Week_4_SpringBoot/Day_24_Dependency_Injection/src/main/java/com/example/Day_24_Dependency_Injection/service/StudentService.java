package com.example.Day_24_Dependency_Injection.service;

import com.example.Day_24_Dependency_Injection.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 1. @Service tells Spring: "Please create this object for me at startup."
// This puts the object into the "Spring Container" (The Toolbox).
@Service
public class StudentService {

    public List<Student> getStudents() {

        // Imagine this data is coming from a database (we will do that tomorrow)
        List<Student> list = new ArrayList<>();
        list.add(new Student("Tony Stark", "Tech Lead"));
        list.add(new Student("Steve Rogers", "Team Captain"));
        list.add(new Student("Bruce Banner", "Data Scientist"));
        return list;
    }
}
