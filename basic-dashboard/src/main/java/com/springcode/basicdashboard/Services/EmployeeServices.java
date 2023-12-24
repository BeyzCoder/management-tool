package com.springcode.basicdashboard.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springcode.basicdashboard.Database.DepartmentRepository;
import com.springcode.basicdashboard.Database.EmployeeRepository;
import com.springcode.basicdashboard.Database.TaskRepository;
import com.springcode.basicdashboard.Models.Department;
import com.springcode.basicdashboard.Models.Employee;
import com.springcode.basicdashboard.Models.Task;

@Service
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final TaskRepository taskRepository;

    public EmployeeServices(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, 
            TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.taskRepository = taskRepository;
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Long id) {
        return this.employeeRepository.findById(id);
    }

    public Employee registerNewEmployee(Employee employee) {
        Department department = this.departmentRepository.findById(employee.getDepartment().getId()).get();

        employee.setDepartment(department);

        return this.employeeRepository.save(employee);
    }

    public void setNewDepartment(Long emp_id, Long dept_id) {
        Department department = this.departmentRepository.findById(dept_id).get();
        Employee employee = this.employeeRepository.findById(emp_id).get();

        department.addEmployee(employee);
        employee.setDepartment(department);

        this.departmentRepository.save(department);
        this.employeeRepository.save(employee);
    }

    public void addNewTasks(Long id, List<Task> tasks) {
        Employee employee = this.employeeRepository.getReferenceById(id);
        employee.setTasks(tasks);
        this.taskRepository.saveAll(tasks);
    }

    public Employee editEmployeeProfile(Employee edit_employee) {
        return this.employeeRepository.save(edit_employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = this.employeeRepository.findById(id).get();
        this.employeeRepository.delete(employee);
    }

    public void removeOldTask(Long emp_id, Long task_id) {
        Task task = this.taskRepository.findById(task_id).get();
        this.employeeRepository.findById(emp_id).get().removeTask(task);
        this.taskRepository.deleteById(task_id);
    }
}
