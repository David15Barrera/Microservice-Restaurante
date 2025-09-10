package com.service.restaurantService.order.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PromotionDomainEntity {
    private UUID id;
    private String name;
    private String description;
    private String type;
    private BigDecimal discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID hotelId;
    private UUID restaurantId;
    private UUID customerId;
    private UUID roomId;
    private UUID dishId;
}
