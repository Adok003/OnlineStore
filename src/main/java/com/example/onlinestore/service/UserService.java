package com.example.onlinestore.service;

import com.example.onlinestore.Entity.User;
import com.example.onlinestore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerNewUser(User user) {
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userRepository.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}