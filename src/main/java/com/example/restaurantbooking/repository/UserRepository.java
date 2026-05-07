package com.example.restaurantbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurantbooking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}