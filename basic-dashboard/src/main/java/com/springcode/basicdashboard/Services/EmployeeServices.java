package com.springcode.basicdashboard.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springcode.basicdashboard.Database.EmployeeRepository;
import com.springcode.basicdashboard.Models.Employee;

@Service
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public void registerNewEmployee(Employee employee) {
        System.out.println(employee);
        this.employeeRepository.save(employee);
    }
}
