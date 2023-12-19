package com.springcode.basicdashboard.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcode.basicdashboard.Models.Employee;
import com.springcode.basicdashboard.Services.EmployeeServices;

@RestController
@RequestMapping(path="dashboard/employee")
public class EmployeeController {

    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/")
    public List<Employee> getEmployee() {
        return this.employeeServices.getAllEmployee();
    }

    @PostMapping("/")
    public void entryNewTask(@RequestBody Employee employee) {
        System.out.println(employee);
        this.employeeServices.registerNewEmployee(employee);
    }
}
