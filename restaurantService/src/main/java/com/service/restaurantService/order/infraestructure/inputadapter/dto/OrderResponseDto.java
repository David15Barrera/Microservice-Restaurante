package com.service.restaurantService.order.infraestructure.inputadapter.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class OrderResponseDto {
    public Integer id;
    public UUID customerId;
    public UUID restaurantId;
    public OffsetDateTime date;
    public BigDecimal totalPrice;
    public BigDecimal discountPercentage;
    public UUID promotionId;
    public OffsetDateTime createdAt;

    public CustomerResponse customer;
}
