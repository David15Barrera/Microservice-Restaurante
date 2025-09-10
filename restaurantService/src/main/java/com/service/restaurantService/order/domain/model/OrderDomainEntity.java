package com.service.restaurantService.order.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class OrderDomainEntity {
    private UUID id;
    private UUID customerId;
    private UUID restaurantId;
    private OffsetDateTime date;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private UUID promotionId;
    private OffsetDateTime createdAt;

    private CustomerDomainEntity customer;
    private PromotionDomainEntity promotion;

}
