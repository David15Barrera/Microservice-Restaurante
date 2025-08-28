package com.service.restaurantService.restaurant.adapters.in.web.dto;

import java.time.LocalTime;
import java.util.UUID;

public class RestaurantResponse {
    public UUID id;
    public String name;
    public UUID hotelId;
    public String address;
    public String phone;
    public Integer capacity;
    public LocalTime openingTime;
    public LocalTime closingTime;
}
