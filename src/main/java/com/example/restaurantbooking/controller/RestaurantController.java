package com.example.restaurantbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.restaurantbooking.model.Restaurant;
import com.example.restaurantbooking.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin("*")
public class RestaurantController {

@Autowired
RestaurantRepository repo;

@PostMapping
public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
return repo.save(restaurant);
}

@GetMapping
public List<Restaurant> getAll(){
return repo.findAll();
}

}