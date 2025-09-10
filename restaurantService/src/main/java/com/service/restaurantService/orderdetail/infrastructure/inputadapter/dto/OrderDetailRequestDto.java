package com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderDetailRequestDto {
    public UUID orderId;
    public UUID dishId;
    public Integer quantity;
    public BigDecimal unitPrice;
    public BigDecimal unitCost;
    public BigDecimal discountPercentage;
    public UUID promotionId;
}
