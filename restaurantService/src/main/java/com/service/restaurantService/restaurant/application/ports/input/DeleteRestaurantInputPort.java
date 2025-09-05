package com.service.restaurantService.restaurant.application.ports.input;

import java.util.UUID;

public interface DeleteRestaurantInputPort {
    void deleteById(UUID id);
}
