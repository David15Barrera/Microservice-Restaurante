package com.service.restaurantService.fooddish.application.ports.output;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

import java.util.List;
import java.util.Optional;

public interface SaveFoodDishOutputPort {
    FoodDishDomainEntity save(FoodDishDomainEntity dish);
    void deleteById(Integer id);
    Optional<FoodDishDomainEntity> findById(Integer id);
    List<FoodDishDomainEntity> findAll();
}
