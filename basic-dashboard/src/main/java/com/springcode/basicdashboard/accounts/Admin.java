package com.springcode.basicdashboard.accounts;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Account {

    private List<Employee> listEmployees;

    public Admin(int id, String username, String email) {
        super(id, username, email, "Admin");
        this.listEmployees = new ArrayList<Employee>();
    }
    
    public List<Employee> getListEmployee() {
        return listEmployees;
    }

    public void setListEmployee(Employee employee) {
        this.listEmployees.add(employee);
    }
}
