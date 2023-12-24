package com.springcode.basicdashboard.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcode.basicdashboard.Models.Department;
import com.springcode.basicdashboard.Services.DepartmentServices;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="department")
public class DepartmentController {

    private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return this.departmentServices.getAllDepartments();
    }
    
    @PostMapping("/")
    public Department enterDepartmentField(@RequestBody Department department) {
        return this.departmentServices.registerNewField(department);
    }
}
