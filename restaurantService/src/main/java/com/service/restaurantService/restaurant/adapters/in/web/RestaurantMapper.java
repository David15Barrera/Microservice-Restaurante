package com.service.restaurantService.restaurant.adapters.in.web;


import com.service.restaurantService.restaurant.adapters.in.web.dto.RestaurantRequest;
import com.service.restaurantService.restaurant.adapters.in.web.dto.RestaurantResponse;
import com.service.restaurantService.restaurant.domain.model.Restaurant;

public class RestaurantMapper {
    public static Restaurant toDomain(RestaurantRequest req) {
        Restaurant r = new Restaurant();
        r.setName(req.name);
        r.setHotelId(req.hotelId);
        r.setAddress(req.address);
        r.setPhone(req.phone);
        r.setCapacity(req.capacity);
        r.setOpeningTime(req.openingTime);
        r.setClosingTime(req.closingTime);
        return r;
    }
    public static RestaurantResponse toResponse(Restaurant r) {
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
}
