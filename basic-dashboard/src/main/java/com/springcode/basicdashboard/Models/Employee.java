package com.springcode.basicdashboard.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Employee extends Account {

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin employeeAdmin;

    @OneToMany(mappedBy = "taskEmployee", cascade = CascadeType.ALL)
    private List<Task> listTasks;
    
    public Employee(String username, String email) {
        super(username, email, "Employee");
    }

    public Employee(Long id, String username, String email) {
        super(id, username, email, "Employee");
    }

    public List<Task> getListTasks() {
        return listTasks;
    }

    public void setListTasks(Task task) {
        this.listTasks.add(task);
    }

}
