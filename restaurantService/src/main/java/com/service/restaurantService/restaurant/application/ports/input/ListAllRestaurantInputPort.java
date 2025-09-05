package com.service.restaurantService.restaurant.application.ports.input;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;

import java.util.List;

public interface ListAllRestaurantInputPort {
    List<RestaurantDomainEntity> listAll();
}
