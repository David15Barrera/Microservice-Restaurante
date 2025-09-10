package com.service.restaurantService.fooddish.application.ports.output;

import java.util.UUID;

public interface DeleteFoodDishOutputPort {
    void deleteById(UUID id);
}
