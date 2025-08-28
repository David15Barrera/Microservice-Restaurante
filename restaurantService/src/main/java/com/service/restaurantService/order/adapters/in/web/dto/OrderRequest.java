package com.service.restaurantService.order.adapters.in.web.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
public class OrderRequest {
    @NotNull
    public UUID customerId;

    @NotNull
    public UUID restaurantId;
    public LocalDateTime date;

    @NotNull
    public BigDecimal totalPrice;
    public BigDecimal discountPercentage;
    public UUID promotionId;
}

