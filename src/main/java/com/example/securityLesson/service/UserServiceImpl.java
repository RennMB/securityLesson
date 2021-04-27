package com.example.securityLesson.service;

import com.example.securityLesson.model.User;
import com.example.securityLesson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public User create(User user){
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        user.setPassword(b.encode(user.getPassword()));
        return userRepository.save(user);}

    @Override
    public User update(User user){return userRepository.save(user);}

    @Override
    public void delete(Long id){userRepository.deleteById(id);}

    @Override
    public List<User> getAll(){return userRepository.findAll();}
}
