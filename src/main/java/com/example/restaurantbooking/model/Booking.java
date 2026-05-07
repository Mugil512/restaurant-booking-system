package com.example.restaurantbooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @Min(value = 1, message = "Number of people must be at least 1")
    private int numberOfPeople;

    @NotBlank(message = "Restaurant name is required")
    private String restaurantName;

    @NotNull(message = "Booking date is required")
    private String bookingDate;

    @NotNull(message = "Booking time is required")
    private String bookingTime;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getNumberOfPeople() { return numberOfPeople; }
    public void setNumberOfPeople(int numberOfPeople) { this.numberOfPeople = numberOfPeople; }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getBookingTime() { return bookingTime; }
    public void setBookingTime(String bookingTime) { this.bookingTime = bookingTime; }
}