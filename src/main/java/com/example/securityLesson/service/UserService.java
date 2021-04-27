package com.example.securityLesson.service;

import com.example.securityLesson.model.User;

import java.util.List;

public interface UserService {

    User create (User user);
    User update (User user);
    void delete(Long id);
    List<User> getAll();
}
