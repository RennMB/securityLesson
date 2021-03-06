package com.example.securityLesson.controller;

import com.example.securityLesson.model.Task;
import com.example.securityLesson.repository.UserRepository;
import com.example.securityLesson.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskService taskService;

    @Secured("ROLE_USER")
    @GetMapping("/getMyTasks")
    public List<Task> getMyTasks(Principal principal){
        return taskService.getMyTasks(principal.getName());
    }

    @Secured("ROLE_USER")
    @PostMapping("/create")
    public Task create(@RequestBody Task task, Principal principal){
        task.setUser(userRepository.findByUsername(principal.getName()));
        return taskService.create(task);
    }
}
