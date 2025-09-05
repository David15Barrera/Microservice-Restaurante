package com.service.restaurantService.restaurant.application.usecase.update;

import com.service.restaurantService.restaurant.application.ports.input.UpdateRestaurantInputPort;
import com.service.restaurantService.restaurant.application.ports.output.SaveRestaurantOutputPort;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateRestaurantUseCase implements UpdateRestaurantInputPort {

    private final SaveRestaurantOutputPort outputPort;

    public UpdateRestaurantUseCase(SaveRestaurantOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public RestaurantDomainEntity update(RestaurantDomainEntity restaurant) {
        if (restaurant.getId() == null) {
            throw new IllegalArgumentException("Restaurant id is required for update");
        }
        return outputPort.save(restaurant);
    }
}
