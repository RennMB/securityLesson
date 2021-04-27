package com.example.securityLesson.service;

import com.example.securityLesson.model.Task;
import com.example.securityLesson.model.UserRole;

import java.util.List;

public interface TaskService {

    Task create (Task task);
    Task update (Task task);
    void delete(Long id);
    List<Task> getMyTasks(String username);
}
