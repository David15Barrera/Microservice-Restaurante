package com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PromotionResponse {
    public UUID id;
    public String name;
    public String description;
    public String type;
    public BigDecimal discountPercentage;
    public LocalDate startDate;
    public LocalDate endDate;
    public UUID hotelId;
    public UUID restaurantId;
    public UUID customerId;
    public UUID roomId;
    public Integer dishId;
}
