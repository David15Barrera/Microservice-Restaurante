package com.service.restaurantService.restaurant.application.ports.input;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;

public interface UpdateRestaurantInputPort {
    RestaurantDomainEntity update(RestaurantDomainEntity restaurant);
}
