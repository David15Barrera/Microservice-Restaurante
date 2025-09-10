package com.service.restaurantService.order.application.ports.output;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaveOrderOutputPort {
    OrderDomainEntity save(OrderDomainEntity order);
    void deleteById(UUID id);
    Optional<OrderDomainEntity> findById(UUID id);
    List<OrderDomainEntity> findAll();
}
