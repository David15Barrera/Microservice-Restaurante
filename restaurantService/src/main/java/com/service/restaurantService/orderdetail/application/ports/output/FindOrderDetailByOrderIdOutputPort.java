package com.service.restaurantService.orderdetail.application.ports.output;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindOrderDetailByOrderIdOutputPort {
    List<OrderDetailDomainEntity> findByOrderId(UUID orderId);
}
