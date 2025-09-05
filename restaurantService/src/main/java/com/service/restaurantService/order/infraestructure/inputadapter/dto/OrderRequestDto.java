package com.service.restaurantService.order.infraestructure.inputadapter.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderRequestDto {
    public UUID customerId;
    public UUID restaurantId;
    public BigDecimal totalPrice;
    public BigDecimal discountPercentage;
    public UUID promotionId;
}
