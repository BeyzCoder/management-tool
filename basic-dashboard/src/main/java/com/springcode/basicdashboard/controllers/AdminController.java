package com.springcode.basicdashboard.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcode.basicdashboard.AccountServices;
import com.springcode.basicdashboard.accounts.Employee;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="dashboard/admin")
public class AdminController {

    private final AccountServices accountServices;

    public AdminController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    @GetMapping("/{id}")
    public List<Employee> getEmployees(@PathVariable int id) {
        return this.accountServices.getAdminsEmployees(id);
    }
    
    @PostMapping("/{id}")
    public void registerNewEmployee(@PathVariable int id, @RequestBody Employee employee) {
        this.accountServices.addEmployee(employee, id);
    }
    
}
