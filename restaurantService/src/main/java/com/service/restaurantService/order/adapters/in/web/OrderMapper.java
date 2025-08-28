package com.service.restaurantService.order.adapters.in.web;

import com.service.restaurantService.order.adapters.in.web.dto.*;
import com.service.restaurantService.order.domain.model.Order;

public class OrderMapper {

    public static Order toDomain(OrderRequest req){
        Order o=new Order();
        o.setCustomerId(req.customerId);
        o.setRestaurantId(req.restaurantId);
        o.setDate(req.date);
        o.setTotalPrice(req.totalPrice);
        o.setDiscountPercentage(req.discountPercentage);
        o.setPromotionId(req.promotionId);
        return o;
    }

    public static OrderResponse toResponse(Order o){
        OrderResponse r=new OrderResponse();
        r.id=o.getId();
        r.customerId=o.getCustomerId();
        r.restaurantId=o.getRestaurantId();
        r.date=o.getDate();
        r.totalPrice=o.getTotalPrice();
        r.discountPercentage=o.getDiscountPercentage();
        r.promotionId=o.getPromotionId();
        return r;
    }
}
