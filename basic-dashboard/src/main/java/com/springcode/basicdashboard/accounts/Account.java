package com.springcode.basicdashboard.accounts;

public class Account {
    
    private int id;
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
    
    public Account(int id, String username, String email, String position) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.position = position;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
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
