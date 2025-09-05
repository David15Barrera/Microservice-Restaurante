package com.service.restaurantService.order.application.ports.output;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindOrdersByRestaurantOutputPort {
    List<OrderDomainEntity> findByRestaurantId(UUID restaurantId);
}
