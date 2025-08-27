package com.service.restaurantService.domain.port.out;


import com.service.restaurantService.domain.model.FoodDish;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FoodDishRepositoryPort {
    FoodDish save(FoodDish dish);
    Optional<FoodDish> findById(Integer id);
    List<FoodDish> findByRestaurantId(UUID restaurantId);
    List<FoodDish> findAll();
    void deleteById(Integer id);
}
