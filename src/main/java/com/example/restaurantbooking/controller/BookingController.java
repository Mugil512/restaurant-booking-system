package com.example.restaurantbooking.controller;

import com.example.restaurantbooking.model.Booking;
import com.example.restaurantbooking.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

@Autowired
BookingRepository bookingRepository;

@PostMapping
public Booking createBooking(@RequestBody Booking booking){
return bookingRepository.save(booking);
}

@GetMapping
public List<Booking> getBookings(){
return bookingRepository.findAll();
}

@GetMapping("/all")
public List<Booking> getAllBookings(){
return bookingRepository.findAll();
}

@DeleteMapping("/{id}")
public void cancelBooking(@PathVariable Long id){
bookingRepository.deleteById(id);
}

}