package com.springcode.basicdashboard.Models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_desp", nullable = false)
    private String taskDescription;

    @Column(name = "task_date", nullable = false)
    private LocalDate taskCreateDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
    private Employee employee;

    public Task() {
    }

    public Task(String taskDescription, LocalDate taskCreateDate) {
        this.taskDescription = taskDescription;
        this.taskCreateDate = taskCreateDate;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getTaskCreateDate() {
        return taskCreateDate;
    }

    public void setTaskCreateDate(LocalDate taskCreateDate) {
        this.taskCreateDate = taskCreateDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
