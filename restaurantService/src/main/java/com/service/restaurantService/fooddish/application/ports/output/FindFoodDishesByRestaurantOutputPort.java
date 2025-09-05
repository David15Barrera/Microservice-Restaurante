package com.service.restaurantService.fooddish.application.ports.output;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindFoodDishesByRestaurantOutputPort {
    List<FoodDishDomainEntity> findByRestaurantId(UUID restaurantId);
}
