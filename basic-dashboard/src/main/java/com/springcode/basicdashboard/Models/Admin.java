package com.springcode.basicdashboard.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin extends Account {

    @OneToMany(mappedBy = "employeeAdmin", cascade = CascadeType.ALL)
    private List<Employee> listEmployees;

    public Admin () {
        super();
    }

    public Admin(String username, String email) {
        super(username, email, "Admin");
    }

    public List<Employee> getListEmployee() {
        return listEmployees;
    }

    public void setListEmployee(Employee employee) {
        this.listEmployees.add(employee);
    }
}
