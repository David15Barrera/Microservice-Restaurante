package com.service.restaurantService.restaurant.infrastructure.outputadapter.persistence.mapper;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.persistence.entity.RestaurantDBEntity;

public class RestaurantMapper {
    public static RestaurantDomainEntity toDomain(RestaurantDBEntity e) {
        if (e == null) return null;
        RestaurantDomainEntity d = new RestaurantDomainEntity();
        d.setId(e.getId());
        d.setName(e.getName());
        d.setHotelId(e.getHotelId());
        d.setAddress(e.getAddress());
        d.setPhone(e.getPhone());
        d.setCapacity(e.getCapacity());
        d.setOpeningTime(e.getOpeningTime());
        d.setClosingTime(e.getClosingTime());
        d.setCreatedAt(e.getCreatedAt());
        return d;
    }

    public static RestaurantDBEntity toEntity(RestaurantDomainEntity d) {
        if (d == null) return null;
        RestaurantDBEntity e = new RestaurantDBEntity();
        e.setId(d.getId());
        e.setName(d.getName());
        e.setHotelId(d.getHotelId());
        e.setAddress(d.getAddress());
        e.setPhone(d.getPhone());
        e.setCapacity(d.getCapacity());
        e.setOpeningTime(d.getOpeningTime());
        e.setClosingTime(d.getClosingTime());
        e.setCreatedAt(d.getCreatedAt());
        return e;
    }
}
