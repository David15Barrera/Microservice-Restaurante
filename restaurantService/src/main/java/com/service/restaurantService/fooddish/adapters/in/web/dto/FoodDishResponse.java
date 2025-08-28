package com.service.restaurantService.fooddish.adapters.in.web.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class FoodDishResponse {
    public Integer id;
    public UUID restaurantId;
    public String name;
    public String description;
    public BigDecimal price;
}
