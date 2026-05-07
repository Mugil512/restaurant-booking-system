package com.example.restaurantbooking.model;

import jakarta.persistence.*;

@Entity
public class Restaurant {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String location;
private String image;
private double rating;

public Long getId() { return id; }

public String getName() { return name; }
public void setName(String name) { this.name = name; }

public String getLocation() { return location; }
public void setLocation(String location) { this.location = location; }

public String getImage() { return image; }
public void setImage(String image) { this.image = image; }

public double getRating() { return rating; }
public void setRating(double rating) { this.rating = rating; }

}