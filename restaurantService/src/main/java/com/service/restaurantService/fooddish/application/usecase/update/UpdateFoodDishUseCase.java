package com.service.restaurantService.fooddish.application.usecase.update;

import com.service.restaurantService.common.application.annotations.UseCase;
import com.service.restaurantService.fooddish.application.ports.input.UpdateFoodDishInputPort;
import com.service.restaurantService.fooddish.application.ports.output.SaveFoodDishOutputPort;
import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import org.springframework.stereotype.Service;

@Service
@UseCase
public class UpdateFoodDishUseCase implements UpdateFoodDishInputPort {

    private final SaveFoodDishOutputPort outputPort;

    public UpdateFoodDishUseCase(SaveFoodDishOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public FoodDishDomainEntity update(FoodDishDomainEntity dish) {
        return outputPort.save(dish);
    }
}
