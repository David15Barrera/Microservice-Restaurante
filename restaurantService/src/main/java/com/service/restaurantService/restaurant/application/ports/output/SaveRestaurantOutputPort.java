package com.service.restaurantService.restaurant.application.ports.output;

import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaveRestaurantOutputPort {
    RestaurantDomainEntity save(RestaurantDomainEntity restaurant);
    void deleteById(UUID id);
    Optional<RestaurantDomainEntity> findById(UUID id);
    List<RestaurantDomainEntity> findAll();
}
