package com.springcode.basicdashboard.tasks;

import java.time.LocalDate;

public class Task {
    
    private LocalDate deadline;
    private String title;
    private String desciption;
    
    public Task(LocalDate deadline, String title, String description) {
        this.deadline = deadline;
        this.title = title;
        this.desciption = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
