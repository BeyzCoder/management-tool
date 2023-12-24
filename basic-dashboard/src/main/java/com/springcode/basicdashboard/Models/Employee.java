package com.springcode.basicdashboard.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "currentWorker", cascade = CascadeType.REMOVE)
    private List<Task> tasks;
    
    public Employee() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    public void setTasks(List<Task> tasks) {
        if (this.tasks == null) {
            this.tasks = new ArrayList<>();
        }
        
        if (tasks != null) {
            this.tasks.clear(); // Clear existing tasks to avoid duplicates
            
            for (Task task : tasks) {
                addTask(task); // Add each task individually to maintain bidirectional consistency
            }
        }
    }

    public void addTask(Task task) {
        if (task != null) {
            task.setCurrentWorker(this); // Set the Employee on the Task to maintain bidirectional consistency
            this.tasks.add(task);
        }
    }

    public void removeTask(Task task) {
        if (task != null) {
            task.setCurrentWorker(null); // Remove the reference to this Employee on the Task
            this.tasks.remove(task);
        }
    }
}
