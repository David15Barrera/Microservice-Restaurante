package com.service.restaurantService.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record FoodDishDTO(
        Integer id,
        @NotNull UUID restaurantId,
        @NotBlank String name,
        String description,
        @NotNull BigDecimal price
) {}
