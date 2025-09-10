package com.service.restaurantService.restaurant.infrastructure.inputadapter.dto;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.UUID;

public class RestaurantResponseDto {
    public UUID id;
    public String name;
    public UUID hotelId;
    public String address;
    public String phone;
    public Integer capacity;
    public LocalTime openingTime;
    public LocalTime closingTime;
    public OffsetDateTime createdAt;

    public UUID hotelIdResponse;
    public String hotelName;
    public String hotelAddress;
    public String hotelPhone;
    public Integer hotelTotalRooms;
}
