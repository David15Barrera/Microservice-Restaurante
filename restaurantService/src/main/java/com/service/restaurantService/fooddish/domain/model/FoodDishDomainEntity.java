package com.service.restaurantService.fooddish.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class FoodDishDomainEntity {
    private UUID id;
    private UUID restaurantId;
    private String name;
    private String description;
    private BigDecimal price;
    private OffsetDateTime createdAt;

    public FoodDishDomainEntity() {}

    }


