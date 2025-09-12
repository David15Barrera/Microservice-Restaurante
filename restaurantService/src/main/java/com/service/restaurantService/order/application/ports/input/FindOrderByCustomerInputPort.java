package com.service.restaurantService.order.application.ports.input;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindOrderByCustomerInputPort {
    List<OrderDomainEntity> findByCustomer(UUID customerId);
}
