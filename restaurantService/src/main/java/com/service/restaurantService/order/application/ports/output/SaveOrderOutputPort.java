package com.service.restaurantService.order.application.ports.output;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;

import java.util.List;
import java.util.Optional;

public interface SaveOrderOutputPort {
    OrderDomainEntity save(OrderDomainEntity order);
    void deleteById(Integer id);
    Optional<OrderDomainEntity> findById(Integer id);
    List<OrderDomainEntity> findAll();
}
