package com.springcode.basicdashboard.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcode.basicdashboard.Models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
