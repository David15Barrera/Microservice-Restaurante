package com.service.restaurantService.fooddish.application.ports.input;

import java.util.UUID;

public interface DeleteFoodDishInputPort {
    void deleteById(UUID id);
}
