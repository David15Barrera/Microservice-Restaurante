package com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto;

import java.math.BigDecimal;

public class OrderDetailRequestDto {
    public Integer orderId;
    public Integer dishId;
    public Integer quantity;
    public BigDecimal unitPrice;
    public BigDecimal unitCost;
    public BigDecimal discountPercentage;
}
