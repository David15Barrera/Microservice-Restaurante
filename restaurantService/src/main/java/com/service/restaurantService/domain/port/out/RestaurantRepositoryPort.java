package com.service.restaurantService.domain.port.out;


import com.service.restaurantService.domain.model.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepositoryPort {
    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> findById(UUID id);
    List<Restaurant> findAll();
    void deleteById(UUID id);
}
