package com.service.restaurantService.domain.ports;

import com.service.restaurantService.domain.model.restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepositoryPort {
    restaurant save(restaurant restaurant);
    Optional<restaurant> findById(UUID id);
    List<restaurant> findAll();
    void deleteById(UUID id);
}
