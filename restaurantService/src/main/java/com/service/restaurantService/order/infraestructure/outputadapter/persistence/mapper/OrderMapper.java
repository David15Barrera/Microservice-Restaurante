package com.service.restaurantService.order.infraestructure.outputadapter.persistence.mapper;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import com.service.restaurantService.order.infraestructure.outputadapter.persistence.entity.OrderDBEntity;

public class OrderMapper {
    public static OrderDomainEntity toDomain(OrderDBEntity e) {
        if (e == null) return null;
        OrderDomainEntity d = new OrderDomainEntity();
        d.setId(e.getId());
        d.setCustomerId(e.getCustomerId());
        d.setRestaurantId(e.getRestaurantId());
        d.setDate(e.getDate());
        d.setTotalPrice(e.getTotalPrice());
        d.setDiscountPercentage(e.getDiscountPercentage());
        d.setPromotionId(e.getPromotionId());
        d.setCreatedAt(e.getCreatedAt());
        d.setStatus(e.getStatus());
        return d;
    }

    public static OrderDBEntity toEntity(OrderDomainEntity d) {
        if (d == null) return null;
        OrderDBEntity e = new OrderDBEntity();
        e.setId(d.getId());
        e.setCustomerId(d.getCustomerId());
        e.setRestaurantId(d.getRestaurantId());
        e.setDate(d.getDate());
        e.setTotalPrice(d.getTotalPrice());
        e.setDiscountPercentage(d.getDiscountPercentage());
        e.setPromotionId(d.getPromotionId());
        e.setCreatedAt(d.getCreatedAt());
        e.setStatus(d.getStatus());
        return e;
    }
}
