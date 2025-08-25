package com.service.restaurantService.adapters.inPort.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderDetailResponse {
    public Integer id;
    public Integer orderId;
    public UUID dishId;
    public Integer quantity;
    public BigDecimal unitPrice;
    public BigDecimal unitCost;
    public BigDecimal subtotal;
    public BigDecimal discountPercentage;
    public UUID promotionId;
}
