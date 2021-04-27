package com.example.securityLesson.service;

import com.example.securityLesson.model.User;
import com.example.securityLesson.model.UserRole;

import java.util.List;

public interface UserRoleService {

    UserRole create (UserRole userRole);
    UserRole update (UserRole userRole);
    void delete(Long id);
    List<UserRole> getAll();
}
