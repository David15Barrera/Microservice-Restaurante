package com.service.restaurantService.adapters.inPort.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class DishRequest {
    @NotNull public UUID restaurantId;
    @NotBlank public String name;
    public String description;
    @NotNull public BigDecimal price;
}
