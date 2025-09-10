package com.service.restaurantService.orderdetail.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDomainEntity {
    private Integer id;
    private UUID orderId;
    private UUID dishId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal unitCost;
    private BigDecimal subtotal;
    private BigDecimal discountPercentage;
    private OffsetDateTime createdAt;
    private UUID promotionId;

    private PromotionDomainEntity promotion;
}
