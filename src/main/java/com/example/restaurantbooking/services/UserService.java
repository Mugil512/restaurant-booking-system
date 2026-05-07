package com.example.restaurantbooking.services;

import com.example.restaurantbooking.model.User;
import com.example.restaurantbooking.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // REGISTER USER
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // LOGIN USER
    public User loginUser(String username, String password) {

        User user = userRepository.findByUsername(username);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("Invalid Username or Password");
        }
    }

}