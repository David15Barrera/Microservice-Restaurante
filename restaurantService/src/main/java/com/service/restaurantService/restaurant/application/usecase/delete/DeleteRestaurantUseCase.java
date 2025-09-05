package com.service.restaurantService.restaurant.application.usecase.delete;

import com.service.restaurantService.restaurant.application.ports.input.DeleteRestaurantInputPort;
import com.service.restaurantService.restaurant.application.ports.output.SaveRestaurantOutputPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteRestaurantUseCase implements DeleteRestaurantInputPort {

    private final SaveRestaurantOutputPort outputPort;

    public DeleteRestaurantUseCase(SaveRestaurantOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void deleteById(UUID id) {
        outputPort.deleteById(id);
    }
}
