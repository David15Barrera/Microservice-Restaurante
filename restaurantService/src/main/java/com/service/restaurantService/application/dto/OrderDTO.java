package com.service.restaurantService.application.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderDTO(
        Integer id,
        @NotNull UUID customerId,
        @NotNull UUID restaurantId,
        Instant date,
        BigDecimal totalPrice,
        BigDecimal discountPercentage,
        UUID promotionId,
        List<OrderDetailDTO> details
) {}
