package com.service.restaurantService.adapters.outPort.persistance.mapper;


import com.service.restaurantService.adapters.outPort.persistance.entity.DishEntity;
import com.service.restaurantService.adapters.outPort.persistance.entity.OrderDetailEntity;
import com.service.restaurantService.adapters.outPort.persistance.entity.OrderEntity;
import com.service.restaurantService.adapters.outPort.persistance.entity.RestaurantEntity;
import com.service.restaurantService.domain.model.dish;
import com.service.restaurantService.domain.model.order;
import com.service.restaurantService.domain.model.orderDetail;
import com.service.restaurantService.domain.model.restaurant;

public class PersistenceMapper {

    public static RestaurantEntity toEntity(restaurant r) {
        if (r == null) return null;
        RestaurantEntity e = new RestaurantEntity();
        e.setId(r.getId());
        e.setName(r.getName());
        e.setHotelId(r.getHotelId());
        e.setAddress(r.getAddress());
        e.setPhone(r.getPhone());
        e.setCapacity(r.getCapacity());
        e.setOpeningTime(r.getOpeningTime());
        e.setClosingTime(r.getClosingTime());
        return e;
    }
    public static restaurant toDomain(RestaurantEntity e) {
        if (e == null) return null;
        restaurant r = new restaurant();
        r.setId(e.getId());
        r.setName(e.getName());
        r.setHotelId(e.getHotelId());
        r.setAddress(e.getAddress());
        r.setPhone(e.getPhone());
        r.setCapacity(e.getCapacity());
        r.setOpeningTime(e.getOpeningTime());
        r.setClosingTime(e.getClosingTime());
        return r;
    }

    public static DishEntity toEntity(dish d) {
        if (d == null) return null;
        DishEntity e = new DishEntity();
        e.setId(d.getId());
        e.setRestaurantId(d.getRestaurantId());
        e.setName(d.getName());
        e.setDescription(d.getDescription());
        e.setPrice(d.getPrice());
        return e;
    }
    public static dish toDomain(DishEntity e) {
        if (e == null) return null;
        dish d = new dish();
        d.setId(e.getId());
        d.setRestaurantId(e.getRestaurantId());
        d.setName(e.getName());
        d.setDescription(e.getDescription());
        d.setPrice(e.getPrice());
        return d;
    }

    public static OrderEntity toEntity(order o) {
        if (o == null) return null;
        OrderEntity e = new OrderEntity();
        e.setId(o.getId());
        e.setCustomerId(o.getCustomerId());
        e.setRestaurantId(o.getRestaurantId());
        e.setDate(o.getDate());
        e.setTotalPrice(o.getTotalPrice());
        e.setDiscountPercentage(o.getDiscountPercentage());
        e.setPromotionId(o.getPromotionId());
        return e;
    }
    public static order toDomain(OrderEntity e) {
        if (e == null) return null;
        order o = new order();
        o.setId(e.getId());
        o.setCustomerId(e.getCustomerId());
        o.setRestaurantId(e.getRestaurantId());
        o.setDate(e.getDate());
        o.setTotalPrice(e.getTotalPrice());
        o.setDiscountPercentage(e.getDiscountPercentage());
        o.setPromotionId(e.getPromotionId());
        return o;
    }

    public static OrderDetailEntity toEntity(orderDetail d) {
        if (d == null) return null;
        OrderDetailEntity e = new OrderDetailEntity();
        e.setId(d.getId());
        e.setOrderId(d.getOrderId());
        e.setDishId(d.getDishId());
        e.setQuantity(d.getQuantity());
        e.setUnitPrice(d.getUnitPrice());
        e.setUnitCost(d.getUnitCost());
        e.setSubtotal(d.getSubtotal());
        e.setDiscountPercentage(d.getDiscountPercentage());
        e.setPromotionId(d.getPromotionId());
        return e;
    }
    public static orderDetail toDomain(OrderDetailEntity e) {
        if (e == null) return null;
        orderDetail d = new orderDetail();
        d.setId(e.getId());
        d.setOrderId(e.getOrderId());
        d.setDishId(e.getDishId());
        d.setQuantity(e.getQuantity());
        d.setUnitPrice(e.getUnitPrice());
        d.setUnitCost(e.getUnitCost());
        d.setSubtotal(e.getSubtotal());
        d.setDiscountPercentage(e.getDiscountPercentage());
        d.setPromotionId(e.getPromotionId());
        return d;
    }
}
