package com.springcode.basicdashboard;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcode.basicdashboard.Models.Employee;

@Service
public class AccountServices {

    private final AdminRepository adminRepository;

    public AccountServices(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Employee> getAdminEmployees() {
        return this.adminRepository.findAll().get(0).getListEmployee();
    }

    // public List<Employee> getAdminsEmployees(int id) throws NoSuchElementException {
    //     try {
    //         List<Employee> employees = this.listAdmins.get(id).getListEmployee();
    //         return employees;
    //     } catch (NoSuchElementException e) {
    //         throw new NoSuchElementException("There was no admin with the ID of "+id);
    //     }
    // }

    // public List<Task> getEmployeeTasks(int id) throws NoSuchElementException {
    //     try {
    //         List<Task> tasks = this.listEmployees.get(id).getListTasks();
    //         return tasks;
    //     } catch (NoSuchElementException e) {
    //         throw new NoSuchElementException("There was no employee with the ID of "+id);
    //     }
    // }

    // public void addEmployee(Employee employee, int id) {
    //     this.listAdmins.get(id).setListEmployee(employee);
    //     this.listEmployees.add(employee);
    // }

    // public void addTask(Task task, int id) {
    //     this.listEmployees.get(id).setListTasks(task);
    // }
}
