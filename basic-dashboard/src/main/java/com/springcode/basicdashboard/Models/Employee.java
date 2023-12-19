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
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;
    
    @Column(name =  "emp_name", nullable = false)
    private String empName;

    @Column(name = "emp_email", unique = true, nullable = false)
    private String empEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "dept_id")
    private Department department;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Employee() {
    }

    public Employee(String empName, String empEmail) {
        this.empName = empName;
        this.empEmail = empEmail;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
            task.setEmployee(this); // Set the Employee on the Task to maintain bidirectional consistency
            this.tasks.add(task);
        }
    }

    public void removeTask(Task task) {
        if (task != null) {
            task.setEmployee(null); // Remove the reference to this Employee on the Task
            this.tasks.remove(task);
        }
    }

    @Override
    public String toString() {
        return "Employee [id=" + empId + ", name=" + empName + ", email=" + empEmail + ", department=" + department + ", task="
                + tasks + "]";
    }

}
