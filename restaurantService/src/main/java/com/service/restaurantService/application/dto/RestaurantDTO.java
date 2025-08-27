package com.service.restaurantService.application.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;
import java.util.UUID;

public record RestaurantDTO(
        UUID id,
        @NotBlank String name,
        UUID hotelId,
        String address,
        @NotBlank String phone,
        Integer capacity,
        LocalTime openingTime,
        LocalTime closingTime
) {}
