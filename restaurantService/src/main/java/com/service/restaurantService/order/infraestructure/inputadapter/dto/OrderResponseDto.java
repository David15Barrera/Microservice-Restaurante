package com.service.restaurantService.order.infraestructure.inputadapter.dto;

import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.CustomerResponse;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.PromotionResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class OrderResponseDto {
    public UUID id;
    public UUID customerId;
    public UUID restaurantId;
    public OffsetDateTime date;
    public BigDecimal totalPrice;
    public BigDecimal discountPercentage;
    public UUID promotionId;
    public OffsetDateTime createdAt;

    public CustomerResponse customer;
    public PromotionResponse promotion;

}
