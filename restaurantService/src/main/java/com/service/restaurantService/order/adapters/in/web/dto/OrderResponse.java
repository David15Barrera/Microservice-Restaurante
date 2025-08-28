package com.service.restaurantService.order.adapters.in.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderResponse {
    public Integer id;
    public UUID customerId;
    public UUID restaurantId;
    public LocalDateTime date;
    public BigDecimal totalPrice;
    public BigDecimal discountPercentage;
    public UUID promotionId;
}
