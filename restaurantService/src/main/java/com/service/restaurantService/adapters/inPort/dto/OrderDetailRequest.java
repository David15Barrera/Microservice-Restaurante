package com.service.restaurantService.adapters.inPort.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderDetailRequest {
    @NotNull public Integer orderId;
    public UUID dishId;
    @NotNull public Integer quantity;
    @NotNull public BigDecimal unitPrice;
    @NotNull public BigDecimal unitCost;
    public BigDecimal subtotal;
    public BigDecimal discountPercentage;
    public UUID promotionId;
}
