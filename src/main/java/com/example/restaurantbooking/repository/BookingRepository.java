package com.example.restaurantbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurantbooking.model.Booking;
import com.example.restaurantbooking.repository.BookingRepository;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByRestaurantNameAndBookingDateAndBookingTime(
            String restaurantName,
            String bookingDate,
            String bookingTime
    );

}