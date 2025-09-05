package com.service.restaurantService.restaurant.application.ports.input;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;

import java.util.UUID;

public interface GetRestaurantByIdInputPort {
    RestaurantDomainEntity getById(UUID id);
}
