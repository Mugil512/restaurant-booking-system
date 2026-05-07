package com.example.restaurantbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantbooking.model.Booking;
import com.example.restaurantbooking.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Create booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get booking by id
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    // Update booking
    public Booking updateBooking(Long id, Booking bookingDetails) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setCustomerName(bookingDetails.getCustomerName());
        booking.setRestaurantName(bookingDetails.getRestaurantName());
        booking.setBookingDate(bookingDetails.getBookingDate());
        booking.setBookingTime(bookingDetails.getBookingTime());
        booking.setNumberOfPeople(bookingDetails.getNumberOfPeople());

        return bookingRepository.save(booking);
    }

    // Delete booking
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}