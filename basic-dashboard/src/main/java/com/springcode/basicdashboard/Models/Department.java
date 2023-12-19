package com.springcode.basicdashboard.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "field", nullable = false)
    private String field;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee> employeeMembers;
    
    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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
    
    // public Department(String deptName) {
    //     this.deptName = deptName;
    // }
    
    // public Long getDeptId() {
    //     return deptId;
    // }
    
    // public void setDeptId(Long deptId) {
    //     this.deptId = deptId;
    // }
    
    // public String getDeptName() {
    //     return deptName;
    // }
    
    // public void setDeptName(String deptName) {
    //     this.deptName = deptName;
    // }
    
    // public List<Employee> getEmployeeMembers() {
    //     return employeeMembers;
    // }

    // public void setEmployeeMembers(List<Employee> employeeMembers) {
    //     if (this.employeeMembers == null) {
    //         this.employeeMembers = new ArrayList<>();
    //     }

    //     if (employeeMembers != null) {
    //         this.employeeMembers.clear();

    //         for (Employee employee : employeeMembers) {
    //             addEmployee(employee);
    //         }
    //     }
    // }

    // public void addEmployee(Employee employee) {
    //     if (employee != null) {
    //         employee.setDepartment(this);
    //         this.employeeMembers.add(employee);
    //     }
    // }

    // public void removeEmployee(Employee employee) {
    //     if (employee != null) {
    //         employee.setDepartment(null);
    //         this.employeeMembers.remove(employee);
    //     }
    // }
}
