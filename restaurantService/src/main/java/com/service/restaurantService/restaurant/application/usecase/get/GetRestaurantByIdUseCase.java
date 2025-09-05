package com.service.restaurantService.restaurant.application.usecase.get;

import com.service.restaurantService.restaurant.application.ports.input.GetRestaurantByIdInputPort;
import com.service.restaurantService.restaurant.application.ports.output.SaveRestaurantOutputPort;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetRestaurantByIdUseCase implements GetRestaurantByIdInputPort {

    private final SaveRestaurantOutputPort outputPort;

    public GetRestaurantByIdUseCase(SaveRestaurantOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public RestaurantDomainEntity getById(UUID id) {
        return outputPort.findById(id).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
    }
}
