package com.service.restaurantService.order.application.ports.input;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;

public interface CreateOrderInputPort {
    OrderDomainEntity create(OrderDomainEntity order);
}
