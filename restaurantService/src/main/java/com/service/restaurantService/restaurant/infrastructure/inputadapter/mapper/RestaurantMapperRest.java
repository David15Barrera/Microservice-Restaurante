package com.service.restaurantService.restaurant.infrastructure.inputadapter.mapper;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.RestaurantRequestDto;

public class RestaurantMapperRest {
    public static RestaurantDomainEntity toDomain(RestaurantRequestDto r) {
        if (r == null) return null;
        RestaurantDomainEntity d = new RestaurantDomainEntity();
        d.setId(r.id);
        d.setName(r.name);
        d.setHotelId(r.hotelId);
        d.setAddress(r.address);
        d.setPhone(r.phone);
        d.setCapacity(r.capacity);
        d.setOpeningTime(r.openingTime);
        d.setClosingTime(r.closingTime);
        return d;
    }

}
