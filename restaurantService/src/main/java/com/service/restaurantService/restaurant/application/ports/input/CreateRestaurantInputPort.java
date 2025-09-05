package com.service.restaurantService.restaurant.application.ports.input;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;

public interface CreateRestaurantInputPort {
    RestaurantDomainEntity create(RestaurantDomainEntity restaurant);
}
