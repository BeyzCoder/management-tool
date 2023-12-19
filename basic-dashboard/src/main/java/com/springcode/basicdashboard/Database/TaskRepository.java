package com.springcode.basicdashboard.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcode.basicdashboard.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
