package com.springcode.basicdashboard.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employeeMembers;

    
    public Department() {
    }
    
    public Department(String deptName) {
        this.deptName = deptName;
    }
    
    public Long getDeptId() {
        return deptId;
    }
    
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
    
    public String getDeptName() {
        return deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    public List<Employee> getEmployeeMembers() {
        return employeeMembers;
    }

    public void setEmployeeMembers(List<Employee> employeeMembers) {
        if (this.employeeMembers == null) {
            this.employeeMembers = new ArrayList<>();
        }

        if (employeeMembers != null) {
            this.employeeMembers.clear();

            for (Employee employee : employeeMembers) {
                addEmployee(employee);
            }
        }
    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
            employee.setDepartment(this);
            this.employeeMembers.add(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        if (employee != null) {
            employee.setDepartment(null);
            this.employeeMembers.remove(employee);
        }
    }
}
