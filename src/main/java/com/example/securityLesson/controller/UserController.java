package com.example.securityLesson.controller;

import com.example.securityLesson.model.User;
import com.example.securityLesson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    UserService userService;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/getAll")
    public List<User> getAll(){return userService.getAll();}

    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update")
    public User update(@RequestBody User user){
        return  userService.update(user);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id ){
        userService.delete(id);
        return "Deleted already user with id = " + id;}
}
