package com.service.restaurantService.fooddish.application.ports.input;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

public interface GetFoodDishByIdInputPort {
    FoodDishDomainEntity getById(Integer id);
}
