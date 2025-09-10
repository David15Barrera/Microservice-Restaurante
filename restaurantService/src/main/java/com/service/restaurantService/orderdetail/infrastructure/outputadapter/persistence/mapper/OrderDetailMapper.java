package com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.mapper;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.entity.OrderDetailDBEntity;

public class OrderDetailMapper {
    public static OrderDetailDomainEntity toDomain(OrderDetailDBEntity e) {
        if (e == null) return null;
        OrderDetailDomainEntity d = new OrderDetailDomainEntity();
        d.setId(e.getId());
        d.setOrderId(e.getOrderId());
        d.setDishId(e.getDishId());
        d.setQuantity(e.getQuantity());
        d.setUnitPrice(e.getUnitPrice());
        d.setUnitCost(e.getUnitCost());
        d.setSubtotal(e.getSubtotal());
        d.setDiscountPercentage(e.getDiscountPercentage());
        d.setPromotionId(e.getPromotionId());
        d.setCreatedAt(e.getCreatedAt());
        return d;
    }
    public static OrderDetailDBEntity toEntity(OrderDetailDomainEntity d) {
        if (d == null) return null;
        OrderDetailDBEntity e = new OrderDetailDBEntity();
        e.setId(d.getId());
        e.setOrderId(d.getOrderId());
        e.setDishId(d.getDishId());
        e.setQuantity(d.getQuantity());
        e.setUnitPrice(d.getUnitPrice());
        e.setUnitCost(d.getUnitCost());
        e.setSubtotal(d.getSubtotal());
        e.setDiscountPercentage(d.getDiscountPercentage());
        e.setPromotionId(d.getPromotionId());
        e.setCreatedAt(d.getCreatedAt());
        return e;
    }
}
