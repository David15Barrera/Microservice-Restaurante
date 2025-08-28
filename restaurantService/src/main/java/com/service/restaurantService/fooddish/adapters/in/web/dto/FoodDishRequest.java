package com.service.restaurantService.fooddish.adapters.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class FoodDishRequest {
    @NotNull
    public UUID restaurantId;
    @NotBlank
    public String name;
    public String description;
    @NotNull
    public BigDecimal price;
}
