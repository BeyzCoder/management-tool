package com.springcode.basicdashboard.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcode.basicdashboard.Models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>  {
}
