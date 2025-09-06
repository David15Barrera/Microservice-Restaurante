package com.service.restaurantService.restaurant.application.ports.output;

import com.service.restaurantService.restaurant.domain.model.HotelDomainEntity;

import java.util.UUID;

public interface FindHotelOutputPort {
    HotelDomainEntity findById(UUID id);
}
