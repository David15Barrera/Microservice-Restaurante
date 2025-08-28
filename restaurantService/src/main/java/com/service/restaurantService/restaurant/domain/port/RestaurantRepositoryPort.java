package com.service.restaurantService.restaurant.domain.port;


import com.service.restaurantService.restaurant.domain.model.Restaurant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepositoryPort {
    Restaurant save(Restaurant r);
    Optional<Restaurant> findById(UUID id);
    List<Restaurant> findAll();
    void deleteById(UUID id);
}
