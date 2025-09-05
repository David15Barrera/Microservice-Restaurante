package com.service.restaurantService.orderdetail.application.ports.output;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;

import java.util.List;
import java.util.Optional;

public interface SaveOrderDetailOutputPort {
    OrderDetailDomainEntity save(OrderDetailDomainEntity d);
    void deleteById(Integer id);
    Optional<OrderDetailDomainEntity> findById(Integer id);
    List<OrderDetailDomainEntity> findAll();
}
