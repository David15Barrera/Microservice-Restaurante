package com.service.restaurantService.infrastructure.mapper;


import com.service.restaurantService.domain.model.Restaurant;
import com.service.restaurantService.infrastructure.persistence.entity.RestaurantEntity;

public class RestaurantMapper {
    public static RestaurantEntity toEntity(Restaurant r) {
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
    public static Restaurant toDomain(RestaurantEntity e) {
        return new Restaurant(e.getId(), e.getName(), e.getHotelId(), e.getAddress(), e.getPhone(),
                e.getCapacity(), e.getOpeningTime(), e.getClosingTime());
    }
}
