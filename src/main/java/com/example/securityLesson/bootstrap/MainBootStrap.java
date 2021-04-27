package com.example.securityLesson.bootstrap;

import com.example.securityLesson.model.User;
import com.example.securityLesson.model.UserRole;
import com.example.securityLesson.repository.UserRepository;
import com.example.securityLesson.repository.UserRoleRepository;
import com.example.securityLesson.service.UserRoleService;
import com.example.securityLesson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MainBootStrap implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public void run(String... args) throws Exception{
        try{
            User user = new User("user2",  "123");
            userService.create(user);
            UserRole userRole = new UserRole("ROLE_USER", user);
            userRoleService.create(userRole);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
