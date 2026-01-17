package com.sammu.learning.springbootDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/api/v1/students")
    public List<Student> getStudents() {
        return List.of(
                new Student(1, "Alice", "Computer Science",23),
                new Student(2, "Bob", "Mathematics",24),
                new Student(3, "Charlie", "Physics",24)
        );
    }

    @GetMapping("/api/v1/students/id")
    public Student getStudent() {

             return   new Student(1, "Alice", "Computer Science",20);

    }

    static class Student {
        public int id;
        public String name;
        public String major;
        public int age;

        public Student(int id, String name, String major,int age) {
            this.id = id;
            this.name = name;
            this.major = major;
            this.age=age;
        }
    }
}

//row=[0,0,0,3,3,3,6,6,6]
//col=[0.3.6.0.3.6.0,3,6]
