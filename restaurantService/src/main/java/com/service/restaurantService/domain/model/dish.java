package com.service.restaurantService.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class dish {
    private Integer id;
    private UUID restaurantId;
    private String name;
    private String description;
    private BigDecimal price;

    public dish() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public UUID getRestaurantId() { return restaurantId; }
    public void setRestaurantId(UUID restaurantId) { this.restaurantId = restaurantId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

}
