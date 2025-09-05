package com.service.restaurantService.orderdetail.infrastructure.inputadapter.mapper;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto.OrderDetailRequestDto;
import com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto.OrderDetailResponseDto;

public class OrderDetailMapperRest {
    public static OrderDetailDomainEntity toDomain(OrderDetailRequestDto r) {
        if (r == null) return null;
        OrderDetailDomainEntity d = new OrderDetailDomainEntity();
        d.setOrderId(r.orderId);
        d.setDishId(r.dishId);
        d.setQuantity(r.quantity);
        d.setUnitPrice(r.unitPrice);
        d.setUnitCost(r.unitCost);
        d.setDiscountPercentage(r.discountPercentage);
        return d;
    }
    public static OrderDetailResponseDto toResponse(OrderDetailDomainEntity d) {
        if (d == null) return null;
        OrderDetailResponseDto r = new OrderDetailResponseDto();
        r.id = d.getId();
        r.orderId = d.getOrderId();
        r.dishId = d.getDishId();
        r.quantity = d.getQuantity();
        r.unitPrice = d.getUnitPrice();
        r.unitCost = d.getUnitCost();
        r.subtotal = d.getSubtotal();
        r.discountPercentage = d.getDiscountPercentage();
        r.createdAt = d.getCreatedAt();
        return r;
    }
}
