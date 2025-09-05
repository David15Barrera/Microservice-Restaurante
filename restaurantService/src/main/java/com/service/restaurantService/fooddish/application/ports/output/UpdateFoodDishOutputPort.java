package com.service.restaurantService.fooddish.application.ports.output;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

public interface UpdateFoodDishOutputPort {
    FoodDishDomainEntity update(FoodDishDomainEntity dish);
}
