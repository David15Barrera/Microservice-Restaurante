package com.service.restaurantService.orderdetail.adapters.in.web;

import com.service.restaurantService.orderdetail.adapters.in.web.dto.*;
import com.service.restaurantService.orderdetail.domain.model.OrderDetail;

public class OrderDetailMapper {
    public static OrderDetail toDomain(OrderDetailRequest req){
        OrderDetail d=new OrderDetail();
        d.setOrderId(req.orderId);
        d.setDishId(req.dishId);
        d.setQuantity(req.quantity);
        d.setUnitPrice(req.unitPrice);
        d.setUnitCost(req.unitCost);
        d.setSubtotal(req.subtotal);
        d.setDiscountPercentage(req.discountPercentage);
        d.setPromotionId(req.promotionId);
        return d;
    }

    public static OrderDetailResponse toResponse(OrderDetail d){
        OrderDetailResponse r=new OrderDetailResponse();
        r.id=d.getId();
        r.orderId=d.getOrderId();
        r.dishId=d.getDishId();
        r.quantity=d.getQuantity();
        r.unitPrice=d.getUnitPrice();
        r.unitCost=d.getUnitCost();
        r.subtotal=d.getSubtotal();
        r.discountPercentage=d.getDiscountPercentage();
        r.promotionId=d.getPromotionId();
        return r;
    }
}
