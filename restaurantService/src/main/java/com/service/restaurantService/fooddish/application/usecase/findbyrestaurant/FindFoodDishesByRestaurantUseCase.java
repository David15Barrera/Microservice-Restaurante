package com.service.restaurantService.fooddish.application.usecase.findbyrestaurant;

import com.service.restaurantService.fooddish.application.ports.input.FindFoodDishesByRestaurantInputPort;
import com.service.restaurantService.fooddish.application.ports.output.FindFoodDishesByRestaurantOutputPort;
import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindFoodDishesByRestaurantUseCase implements FindFoodDishesByRestaurantInputPort {

    private final FindFoodDishesByRestaurantOutputPort outputPort;

    public FindFoodDishesByRestaurantUseCase(FindFoodDishesByRestaurantOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public List<FoodDishDomainEntity> findByRestaurantId(UUID restaurantId) {
        return outputPort.findByRestaurantId(restaurantId);
    }
}
