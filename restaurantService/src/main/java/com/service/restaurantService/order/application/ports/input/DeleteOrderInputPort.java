package com.service.restaurantService.order.application.ports.input;

import java.util.UUID;

public interface DeleteOrderInputPort {
    void deleteById(UUID id);
}
