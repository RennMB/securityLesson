package com.example.securityLesson.service;

import com.example.securityLesson.model.Task;
import com.example.securityLesson.model.UserRole;
import com.example.securityLesson.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getMyTasks(String username) {
        return taskRepository.findAll().stream().filter(x -> x.getUser().getUsername().equals(username)).collect(Collectors.toList());
    }

}