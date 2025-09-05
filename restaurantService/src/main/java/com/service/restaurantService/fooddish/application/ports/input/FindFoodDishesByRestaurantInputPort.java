package com.service.restaurantService.fooddish.application.ports.input;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindFoodDishesByRestaurantInputPort {
    List<FoodDishDomainEntity> findByRestaurantId(UUID restaurantId);
}
