package com.springcode.basicdashboard.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcode.basicdashboard.Models.Employee;
import com.springcode.basicdashboard.Models.Task;
import com.springcode.basicdashboard.Services.EmployeeServices;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path="dashboard/employee")
public class EmployeeController {

    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return this.employeeServices.getAllEmployee();
    }
    
    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return this.employeeServices.getEmployee(id);
    }
    
    @PostMapping("/")
    public Employee enterNewEmployee(@RequestBody Employee employee) {
        return this.employeeServices.registerNewEmployee(employee);
    }

    
    @PostMapping("/task/{id}")
    public void enterNewTask(@PathVariable Long id, @RequestBody List<Task> tasks) {
        this.employeeServices.addNewTasks(id, tasks);
    }
    
    @PutMapping("/dept/{emp_id}/{dept_id}")
    public void enterDepartmentField(@PathVariable Long emp_id, @PathVariable Long dept_id) {
        this.employeeServices.setNewDepartment(emp_id, dept_id);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployeeProfile(@PathVariable Long id, @RequestBody Employee edit_employee) {
        Employee employee = this.employeeServices.editEmployeeProfile(id, edit_employee);
        return employee;
    }
    
    @DeleteMapping("/task/{emp_id}/{task_id}")
    public void deleteOldTask(@PathVariable Long emp_id, @PathVariable Long task_id) {
        this.employeeServices.removeOldTask(emp_id, task_id);
    }
}
