package com.service.restaurantService.fooddish.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FoodDishJpaRepository extends JpaRepository<FoodDishEntity, UUID> {
    List<FoodDishEntity> findByRestaurantId(UUID restaurantId);
}
