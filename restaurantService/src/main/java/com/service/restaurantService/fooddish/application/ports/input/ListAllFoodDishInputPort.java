package com.service.restaurantService.fooddish.application.ports.input;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;

import java.util.List;
//@Service
public interface ListAllFoodDishInputPort {
    List<FoodDishDomainEntity> listAll();
}
