package com.service.restaurantService.orderdetail.factory;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;

public class OrderDetailFactory {
    public static OrderDetailDomainEntity create(Integer orderId, Integer dishId, Integer qty) {
        OrderDetailDomainEntity d = new OrderDetailDomainEntity();
        d.setOrderId(orderId);
        d.setDishId(dishId);
        d.setQuantity(qty);
        return d;
    }
}
