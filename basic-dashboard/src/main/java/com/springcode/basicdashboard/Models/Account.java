package com.springcode.basicdashboard.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass 
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    protected String position;
    
    // Theres going to be three constructor.
    public Account() {
    }
    
    // This constructor is for the database because it will generate ID for us.
    public Account(String username, String email, String position) {
        this.username = username;
        this.email = email;
        this.position = position;
    }
    
    public Account(Long id, String username, String email, String position) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.position = position;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", username=" + username + ", email=" + email + ", position=" + position + "]";
    }
}
