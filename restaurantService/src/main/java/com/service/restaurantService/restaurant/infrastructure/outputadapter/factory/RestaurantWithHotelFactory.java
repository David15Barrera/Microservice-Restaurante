package com.service.restaurantService.restaurant.infrastructure.outputadapter.factory;

import com.service.restaurantService.restaurant.application.ports.output.FindHotelOutputPort;
import com.service.restaurantService.restaurant.domain.model.HotelDomainEntity;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.RestaurantResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantWithHotelFactory  {

    private final FindHotelOutputPort hotelOutputPort;

    public RestaurantWithHotelFactory(FindHotelOutputPort hotelOutputPort) {
        this.hotelOutputPort = hotelOutputPort;
    }

    public RestaurantResponseDto fromDomain(RestaurantDomainEntity restaurant) {
        RestaurantResponseDto dto = new RestaurantResponseDto();
        dto.id = restaurant.getId();
        dto.name = restaurant.getName();
        dto.hotelId = restaurant.getHotelId();
        dto.address = restaurant.getAddress();
        dto.phone = restaurant.getPhone();
        dto.capacity = restaurant.getCapacity();
        dto.openingTime = restaurant.getOpeningTime();
        dto.closingTime = restaurant.getClosingTime();
        dto.createdAt = restaurant.getCreatedAt();

        if (restaurant.getHotelId() != null) {
            try {
                HotelDomainEntity hotel = hotelOutputPort.findById(restaurant.getHotelId());
                dto.hotelIdResponse = hotel.getId();
                dto.hotelName = hotel.getName();
                dto.hotelAddress = hotel.getAddress();
                dto.hotelPhone = hotel.getPhone();
                dto.hotelTotalRooms = hotel.getTotalRooms();
            } catch (Exception e) {
                dto.hotelIdResponse = null;
                dto.hotelName = null;
                dto.hotelAddress = null;
                dto.hotelPhone = null;
                dto.hotelTotalRooms = null;
            }
        }

        return dto;
    }

    public List<RestaurantResponseDto> fromDomainList(List<RestaurantDomainEntity> restaurants) {
        return restaurants.stream().map(this::fromDomain).toList();
    }
}