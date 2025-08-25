package com.service.restaurantService.domain.ports;

import com.service.restaurantService.domain.model.dish;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DishRepositoryPort {
    dish save(dish dish);
    Optional<dish> findById(Integer id);
    List<dish> findByRestaurantId(UUID restaurantId);
    List<dish> findAll();
    void deleteById(Integer id);
}
