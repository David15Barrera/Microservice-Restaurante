package com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto;

import com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.dto.PromotionResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class OrderDetailResponseDto {
    public Integer id;
    public UUID orderId;
    public UUID dishId;
    public Integer quantity;
    public BigDecimal unitPrice;
    public BigDecimal unitCost;
    public BigDecimal subtotal;
    public BigDecimal discountPercentage;
    public UUID promotionId;
    public OffsetDateTime createdAt;

    public PromotionResponse promotion;
}
