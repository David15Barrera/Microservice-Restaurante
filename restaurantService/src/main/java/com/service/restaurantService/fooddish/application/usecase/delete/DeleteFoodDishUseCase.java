package com.service.restaurantService.fooddish.application.usecase.delete;

import com.service.restaurantService.fooddish.application.ports.input.DeleteFoodDishInputPort;
import com.service.restaurantService.fooddish.application.ports.output.DeleteFoodDishOutputPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteFoodDishUseCase implements DeleteFoodDishInputPort {

    private final DeleteFoodDishOutputPort outputPort;

    public DeleteFoodDishUseCase(DeleteFoodDishOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void deleteById(Integer id) {
        outputPort.deleteById(id);
    }
}