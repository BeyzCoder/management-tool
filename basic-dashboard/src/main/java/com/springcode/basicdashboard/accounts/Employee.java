package com.springcode.basicdashboard.accounts;

import java.util.ArrayList;
import java.util.List;

import com.springcode.basicdashboard.tasks.Task;

public class Employee extends Account {

    private List<Task> listTasks;
    
    public Employee(int id, String username, String email) {
        super(id, username, email, "Employee");
        this.listTasks = new ArrayList<Task>();
    }

    public List<Task> getListTasks() {
        return listTasks;
    }

    public void setListTasks(Task task) {
        this.listTasks.add(task);
    }

}
