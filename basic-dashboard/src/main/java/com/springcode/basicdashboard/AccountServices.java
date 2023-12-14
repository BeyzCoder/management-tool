package com.springcode.basicdashboard;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.springcode.basicdashboard.accounts.Admin;
import com.springcode.basicdashboard.accounts.Employee;
import com.springcode.basicdashboard.tasks.Task;

@Service
public class AccountServices {

    // Dummy List
    private List<Admin> listAdmins;
    private List<Employee> listEmployees;

    public AccountServices() {
        // dummy element
        this.listAdmins = new ArrayList<Admin>();
        this.listEmployees = new ArrayList<Employee>();
        
        this.listAdmins.add(new Admin(0, "Steven", "stevenbaes@gmail.com"));
        this.listEmployees.add(new Employee(0, "Kanna", "kannalicous@yahoo.com"));

        this.listAdmins.get(0).setListEmployee(this.listEmployees.get(0));
        this.listEmployees.get(0).setListTasks(new Task(LocalDate.of(2023, Month.DECEMBER, 29), 
        "Project for FCC", "This project is to impress the hiring manager of FCC"));
    }

    public List<Employee> getAdminsEmployees(int id) throws NoSuchElementException {
        try {
            List<Employee> employees = this.listAdmins.get(id).getListEmployee();
            return employees;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("There was no admin with the ID of "+id);
        }
    }

    public List<Task> getEmployeeTasks(int id) throws NoSuchElementException {
        try {
            List<Task> tasks = this.listEmployees.get(id).getListTasks();
            return tasks;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("There was no employee with the ID of "+id);
        }
    }

    public void addEmployee(Employee employee, int id) {
        this.listAdmins.get(id).setListEmployee(employee);
        this.listEmployees.add(employee);
    }

    public void addTask(Task task, int id) {
        this.listEmployees.get(id).setListTasks(task);
    }
}
