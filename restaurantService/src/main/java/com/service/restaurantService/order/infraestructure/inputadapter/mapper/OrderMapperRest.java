package com.service.restaurantService.order.infraestructure.inputadapter.mapper;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderRequestDto;

import java.time.OffsetDateTime;

public class OrderMapperRest {

    public static OrderDomainEntity toDomain(OrderRequestDto dto) {
        if (dto == null) return null;
        OrderDomainEntity d = new OrderDomainEntity();
        d.setCustomerId(dto.customerId);
        d.setRestaurantId(dto.restaurantId);
        d.setTotalPrice(dto.totalPrice);
        d.setDiscountPercentage(dto.discountPercentage);
        d.setPromotionId(dto.promotionId);
        d.setDate(OffsetDateTime.now());
        return d;
    }
}