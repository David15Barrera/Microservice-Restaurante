package com.service.restaurantService.restaurant.adapters.in.web.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;
import java.util.UUID;

public class RestaurantRequest {
    @NotBlank public String name;
    public UUID hotelId;
    public String address;
    @NotBlank public String phone;
    public Integer capacity;
    public LocalTime openingTime;
    public LocalTime closingTime;
}
