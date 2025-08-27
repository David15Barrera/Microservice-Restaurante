package com.service.restaurantService.adapters.inPort.mapper;


import com.service.restaurantService.adapters.inPort.dto.*;
import com.service.restaurantService.domain.model.dish;
import com.service.restaurantService.domain.model.order;
import com.service.restaurantService.domain.model.orderDetail;
import com.service.restaurantService.domain.model.restaurant;

public class WebMapper {
    public static restaurant toDomain(RestaurantRequest r) {
        restaurant d = new restaurant();
        d.setName(r.name);
        d.setHotelId(r.hotelId);
        d.setAddress(r.address);
        d.setPhone(r.phone);
        d.setCapacity(r.capacity);
        d.setOpeningTime(r.openingTime);
        d.setClosingTime(r.closingTime);
        return d;
    }

    public static RestaurantResponse toResponse(restaurant r) {
        RestaurantResponse resp = new RestaurantResponse();
        resp.id = r.getId();
        resp.name = r.getName();
        resp.hotelId = r.getHotelId();
        resp.address = r.getAddress();
        resp.phone = r.getPhone();
        resp.capacity = r.getCapacity();
        resp.openingTime = r.getOpeningTime();
        resp.closingTime = r.getClosingTime();
        return resp;
    }

    public static dish toDomain(DishRequest d) {
        dish x = new dish();
        x.setRestaurantId(d.restaurantId);
        x.setName(d.name);
        x.setDescription(d.description);
        x.setPrice(d.price);
        return x;
    }

    public static DishResponse toResponse(dish d) {
        DishResponse resp = new DishResponse();
        resp.id = d.getId();
        resp.restaurantId = d.getRestaurantId();
        resp.name = d.getName();
        resp.description = d.getDescription();
        resp.price = d.getPrice();
        return resp;
    }

    public static order toDomain(OrderRequest o) {
        order x = new order();
        x.setCustomerId(o.customerId);
        x.setRestaurantId(o.restaurantId);
        x.setDate(o.date);
        x.setTotalPrice(o.totalPrice);
        x.setDiscountPercentage(o.discountPercentage);
        x.setPromotionId(o.promotionId);
        return x;
    }

    public static OrderResponse toResponse(order o) {
        OrderResponse resp = new OrderResponse();
        resp.id = o.getId();
        resp.customerId = o.getCustomerId();
        resp.restaurantId = o.getRestaurantId();
        resp.date = o.getDate();
        resp.totalPrice = o.getTotalPrice();
        resp.discountPercentage = o.getDiscountPercentage();
        resp.promotionId = o.getPromotionId();
        return resp;
    }

    public static orderDetail toDomain(OrderDetailRequest d) {
        orderDetail x = new orderDetail();
        x.setOrderId(d.orderId);
        x.setDishId(d.dishId);
        x.setQuantity(d.quantity);
        x.setUnitPrice(d.unitPrice);
        x.setUnitCost(d.unitCost);
        x.setSubtotal(d.subtotal);
        x.setDiscountPercentage(d.discountPercentage);
        x.setPromotionId(d.promotionId);
        return x;
    }

    public static OrderDetailResponse toResponse(orderDetail d) {
        OrderDetailResponse resp = new OrderDetailResponse();
        resp.id = d.getId();
        resp.orderId = d.getOrderId();
        resp.dishId = d.getDishId();
        resp.quantity = d.getQuantity();
        resp.unitPrice = d.getUnitPrice();
        resp.unitCost = d.getUnitCost();
        resp.subtotal = d.getSubtotal();
        resp.discountPercentage = d.getDiscountPercentage();
        resp.promotionId = d.getPromotionId();
        return resp;
    }
}
