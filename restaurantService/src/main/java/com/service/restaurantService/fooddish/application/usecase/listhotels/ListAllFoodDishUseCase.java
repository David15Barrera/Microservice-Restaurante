package com.service.restaurantService.fooddish.application.usecase.listhotels;

import com.service.restaurantService.fooddish.application.ports.input.ListAllFoodDishInputPort;
import com.service.restaurantService.fooddish.application.ports.output.SaveFoodDishOutputPort;
import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListAllFoodDishUseCase implements ListAllFoodDishInputPort {

    private final SaveFoodDishOutputPort outputPort;

    public ListAllFoodDishUseCase(SaveFoodDishOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public List<FoodDishDomainEntity> listAll() {
        return outputPort.findAll();
    }
}