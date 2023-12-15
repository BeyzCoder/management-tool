package com.springcode.basicdashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcode.basicdashboard.Models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
