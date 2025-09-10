package com.service.restaurantService.order.application.ports.output;

import java.util.UUID;

public interface DeleteOrderOutputPort {
    void deleteById(UUID id);
}
