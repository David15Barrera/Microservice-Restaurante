package com.service.restaurantService.orderdetail.application.ports.input;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindOrderDetailByOrderIdInputPort {
    List<OrderDetailDomainEntity> findByOrderId(UUID orderId);
}
