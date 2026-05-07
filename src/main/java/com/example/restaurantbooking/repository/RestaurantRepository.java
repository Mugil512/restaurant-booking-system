package com.example.restaurantbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurantbooking.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}