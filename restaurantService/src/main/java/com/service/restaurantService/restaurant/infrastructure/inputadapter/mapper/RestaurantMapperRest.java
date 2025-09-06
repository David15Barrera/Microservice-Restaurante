package com.service.restaurantService.restaurant.infrastructure.inputadapter.mapper;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.HotelResponse;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.RestaurantRequestDto;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.RestaurantResponseDto;

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

    public static RestaurantResponseDto toResponse(RestaurantDomainEntity d) {
        if (d == null) return null;
        RestaurantResponseDto r = new RestaurantResponseDto();
        r.id = d.getId();
        r.name = d.getName();
        r.hotelId = d.getHotelId();
        r.address = d.getAddress();
        r.phone = d.getPhone();
        r.capacity = d.getCapacity();
        r.openingTime = d.getOpeningTime();
        r.closingTime = d.getClosingTime();
        r.createdAt = d.getCreatedAt();

        // New logic to map the HotelDomainEntity to HotelResponse
        if (d.getHotel() != null) {
            HotelResponse hotelResponse = new HotelResponse();
            hotelResponse.id = d.getHotel().getId();
            hotelResponse.name = d.getHotel().getName();
            hotelResponse.address = d.getHotel().getAddress();
            hotelResponse.phone = d.getHotel().getPhone();
            hotelResponse.totalRooms = d.getHotel().getTotalRooms();
            r.hotel = hotelResponse;
        }

        return r;
    }
}
