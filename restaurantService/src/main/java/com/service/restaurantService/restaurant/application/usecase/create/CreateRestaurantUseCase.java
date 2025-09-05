package com.service.restaurantService.restaurant.application.usecase.create;

import com.service.restaurantService.restaurant.application.ports.input.CreateRestaurantInputPort;
import com.service.restaurantService.restaurant.application.ports.output.SaveRestaurantOutputPort;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateRestaurantUseCase implements CreateRestaurantInputPort {

    private final SaveRestaurantOutputPort outputPort;

    public CreateRestaurantUseCase(SaveRestaurantOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public RestaurantDomainEntity create(RestaurantDomainEntity restaurant) {
        if (restaurant.getName() == null || restaurant.getName().isBlank()) {
            throw new IllegalArgumentException("Restaurant name is required");
        }
        return outputPort.save(restaurant);
    }
}
