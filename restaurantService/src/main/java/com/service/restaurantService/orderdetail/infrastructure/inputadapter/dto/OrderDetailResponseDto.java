package com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OrderDetailResponseDto {
    public Integer id;
    public Integer orderId;
    public Integer dishId;
    public Integer quantity;
    public BigDecimal unitPrice;
    public BigDecimal unitCost;
    public BigDecimal subtotal;
    public BigDecimal discountPercentage;
    public OffsetDateTime createdAt;
}
