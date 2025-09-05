package com.service.restaurantService.fooddish.infraestructure.inputadapter.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class FoodDishRequestDto {
    public UUID restaurantId;
    public String name;
    public String description;
    public BigDecimal price;
}
