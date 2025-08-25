package com.service.restaurantService.adapters.inPort.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class DishResponse {
    public Integer id;
    public UUID restaurantId;
    public String name;
    public String description;
    public BigDecimal price;
}
