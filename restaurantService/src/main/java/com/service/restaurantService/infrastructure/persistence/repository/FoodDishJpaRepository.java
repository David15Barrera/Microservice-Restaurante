package com.service.restaurantService.infrastructure.persistence.repository;

import com.service.restaurantService.infrastructure.persistence.entity.FoodDishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FoodDishJpaRepository extends JpaRepository<FoodDishEntity, Integer> {
    List<FoodDishEntity> findByRestaurantId(UUID restaurantId);
}
