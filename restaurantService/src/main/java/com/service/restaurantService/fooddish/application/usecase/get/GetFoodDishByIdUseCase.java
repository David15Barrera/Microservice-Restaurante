package com.service.restaurantService.fooddish.application.usecase.get;

import com.service.restaurantService.common.application.annotations.UseCase;
import com.service.restaurantService.fooddish.application.ports.input.GetFoodDishByIdInputPort;
import com.service.restaurantService.fooddish.application.ports.output.SaveFoodDishOutputPort;
import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@UseCase
public class GetFoodDishByIdUseCase implements GetFoodDishByIdInputPort {

    private final SaveFoodDishOutputPort outputPort;

    public GetFoodDishByIdUseCase(SaveFoodDishOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public FoodDishDomainEntity getById(UUID id) {
        Optional<FoodDishDomainEntity> found = outputPort.findById(id);
        return found.orElse(null);
    }
}
