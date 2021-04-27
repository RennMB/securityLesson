package com.example.securityLesson.controller;

import com.example.securityLesson.model.User;
import com.example.securityLesson.model.UserRole;
import com.example.securityLesson.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Secured("ROLE_ADMIN")
@RequestMapping("/api/roles")
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/getAll")
    public List<UserRole> getAll(){return userRoleService.getAll();}

    @PostMapping("/create")
    public UserRole create(@RequestBody UserRole userRole){
        return userRoleService.create(userRole);
    }

    @PostMapping("/update")
    public UserRole update(@RequestBody UserRole userRole){
        return  userRoleService.update(userRole);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id ){
        userRoleService.delete(id);
        return "Deleted already user with id = " + id;}
}
