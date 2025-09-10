package com.service.restaurantService.orderdetail.infrastructure.inputadapter.mapper;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto.OrderDetailRequestDto;

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
        d.setPromotionId(r.promotionId);
        return d;
    }

}
