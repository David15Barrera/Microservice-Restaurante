package com.service.restaurantService.restaurant.infrastructure.inputadapter.dto;

import java.time.LocalTime;
import java.util.UUID;

public class RestaurantRequestDto {
    public UUID id;
    public String name;
    public UUID hotelId;
    public String address;
    public String phone;
    public Integer capacity;
    public LocalTime openingTime;
    public LocalTime closingTime;
}
