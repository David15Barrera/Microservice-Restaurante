package com.service.restaurantService.application.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderDetailDTO(
        Integer id,
        Integer orderId,
        @NotNull Integer dishId,
        @NotNull Integer quantity,
        @NotNull BigDecimal unitPrice,
        @NotNull BigDecimal unitCost,
        BigDecimal subtotal,
        BigDecimal discountPercentage
) {}
