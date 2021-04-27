package com.example.securityLesson.repository;

import com.example.securityLesson.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
