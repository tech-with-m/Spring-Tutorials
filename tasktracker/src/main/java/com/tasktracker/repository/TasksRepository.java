package com.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tasktracker.entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    
}

