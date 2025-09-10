package com.service.restaurantService.fooddish.application.ports.output;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaveFoodDishOutputPort {
    FoodDishDomainEntity save(FoodDishDomainEntity dish);
    void deleteById(UUID id);
    Optional<FoodDishDomainEntity> findById(UUID id);
    List<FoodDishDomainEntity> findAll();
}
