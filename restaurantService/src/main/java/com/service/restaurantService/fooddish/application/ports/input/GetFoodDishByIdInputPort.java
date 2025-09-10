package com.service.restaurantService.fooddish.application.ports.input;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

import java.util.UUID;

public interface GetFoodDishByIdInputPort {
    FoodDishDomainEntity getById(UUID id);
}
