package com.springcode.basicdashboard.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcode.basicdashboard.AccountServices;
import com.springcode.basicdashboard.tasks.Task;

@RestController
@RequestMapping(path="dashboard/employee")
public class EmployeeController {

    private final AccountServices accountServices;

    public EmployeeController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @GetMapping("/{id}")
    public List<Task> getTasks(@PathVariable int id) {
        return this.accountServices.getEmployeeTasks(id);
    }

    @PostMapping("/{id}")
    public void entryNewTask(@PathVariable int id, @RequestBody Task task) {
        this.accountServices.addTask(task, id);
    }
}
