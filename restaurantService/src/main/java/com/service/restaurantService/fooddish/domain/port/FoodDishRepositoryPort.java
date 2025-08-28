package com.service.restaurantService.fooddish.domain.port;

import com.service.restaurantService.fooddish.domain.model.FoodDish;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FoodDishRepositoryPort {
    FoodDish save(FoodDish d);
    Optional<FoodDish> findById(UUID id);
    List<FoodDish> findByRestaurantId(UUID restaurantId);
    List<FoodDish> findAll();
    void deleteById(UUID id);
}
