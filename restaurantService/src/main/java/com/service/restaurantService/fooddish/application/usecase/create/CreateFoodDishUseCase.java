package com.service.restaurantService.fooddish.application.usecase.create;

import com.service.restaurantService.common.application.annotations.UseCase;
import com.service.restaurantService.fooddish.application.ports.input.CreateFoodDishInputPort;
import com.service.restaurantService.fooddish.application.ports.output.SaveFoodDishOutputPort;
import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import org.springframework.stereotype.Service;

@Service
@UseCase
public class CreateFoodDishUseCase implements CreateFoodDishInputPort {

    private final SaveFoodDishOutputPort outputPort;

    public CreateFoodDishUseCase(SaveFoodDishOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public FoodDishDomainEntity create(FoodDishDomainEntity dish) {
        return outputPort.save(dish);
    }
}
