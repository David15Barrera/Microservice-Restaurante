package com.service.restaurantService.restaurant.application.usecase.listhotels;

import com.service.restaurantService.restaurant.application.ports.input.ListAllRestaurantInputPort;
import com.service.restaurantService.restaurant.application.ports.output.SaveRestaurantOutputPort;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllRestaurantUseCase implements ListAllRestaurantInputPort {

    private final SaveRestaurantOutputPort outputPort;

    public ListAllRestaurantUseCase(SaveRestaurantOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public List<RestaurantDomainEntity> listAll() {
        return outputPort.findAll();
    }
}
