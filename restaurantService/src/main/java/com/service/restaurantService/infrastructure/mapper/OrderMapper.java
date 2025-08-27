package com.service.restaurantService.infrastructure.mapper;


import com.service.restaurantService.domain.model.Order;
import com.service.restaurantService.domain.model.OrderDetail;
import com.service.restaurantService.infrastructure.persistence.entity.OrderDetailEntity;
import com.service.restaurantService.infrastructure.persistence.entity.OrderEntity;

import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderEntity toEntity(Order o) {
        OrderEntity e = new OrderEntity();
        e.setId(o.getId());
        e.setCustomerId(o.getCustomerId());
        e.setRestaurantId(o.getRestaurantId());
        e.setDate(o.getDate());
        e.setTotalPrice(o.getTotalPrice());
        e.setDiscountPercentage(o.getDiscountPercentage());
        e.setPromotionId(o.getPromotionId());
        e.setDetails(o.getDetails().stream().map(d -> {
            OrderDetailEntity de = new OrderDetailEntity();
            de.setId(d.getId());
            de.setOrder(e);
            de.setDishId(d.getDishId());
            de.setQuantity(d.getQuantity());
            de.setUnitPrice(d.getUnitPrice());
            de.setUnitCost(d.getUnitCost());
            de.setSubtotal(d.getSubtotal());
            de.setDiscountPercentage(d.getDiscountPercentage());
            return de;
        }).collect(Collectors.toList()));
        return e;
    }

    public static Order toDomain(OrderEntity e) {
        Order o = new Order();
        o.setId(e.getId());
        o.setCustomerId(e.getCustomerId());
        o.setRestaurantId(e.getRestaurantId());
        o.setDate(e.getDate());
        o.setTotalPrice(e.getTotalPrice());
        o.setDiscountPercentage(e.getDiscountPercentage());
        o.setPromotionId(e.getPromotionId());
        o.setDetails(e.getDetails().stream().map(de -> {
            OrderDetail d = new OrderDetail();
            d.setId(de.getId());
            d.setOrderId(e.getId());
            d.setDishId(de.getDishId());
            d.setQuantity(de.getQuantity());
            d.setUnitPrice(de.getUnitPrice());
            d.setUnitCost(de.getUnitCost());
            d.setSubtotal(de.getSubtotal());
            d.setDiscountPercentage(de.getDiscountPercentage());
            return d;
        }).collect(Collectors.toList()));
        return o;
    }
}
