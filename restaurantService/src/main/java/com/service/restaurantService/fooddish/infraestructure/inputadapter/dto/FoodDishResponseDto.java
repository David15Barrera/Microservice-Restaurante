package com.service.restaurantService.fooddish.infraestructure.inputadapter.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class FoodDishResponseDto {
    public UUID id;
    public UUID restaurantId;
    public String name;
    public String description;
    public BigDecimal price;
    public OffsetDateTime createdAt;
}
