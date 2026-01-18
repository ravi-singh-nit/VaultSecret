package com.sammu.learning.springbootDemo.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private int age;
    private String role;
    private boolean active;

    // Constructors
    public User() {
    }

    public User(String name, String email, int age, String role, boolean active) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.role = role;
        this.active = active;
    }


    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

