package com.springcode.basicdashboard.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springcode.basicdashboard.Database.DepartmentRepository;
import com.springcode.basicdashboard.Models.Department;

@Service
public class DepartmentServices {

    private final DepartmentRepository departmentRepository;

    public DepartmentServices(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return this.departmentRepository.findAll();
    }

    public Department registerNewField(Department department) {
        return this.departmentRepository.save(department);
    }
}
