package com.service.restaurantService.order.application.ports.input;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;

import java.util.UUID;

public interface GetOrderByIdInputPort {
    OrderDomainEntity getById(UUID id);
}
