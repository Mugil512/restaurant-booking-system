package com.example.restaurantbooking.controller;

import com.example.restaurantbooking.model.User;
import com.example.restaurantbooking.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired    private UserService userService;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestParam String username,
                      @RequestParam String password) {
        return userService.loginUser(username, password);
    }
}