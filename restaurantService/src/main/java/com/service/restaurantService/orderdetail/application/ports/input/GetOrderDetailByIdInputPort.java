package com.service.restaurantService.orderdetail.application.ports.input;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;

public interface GetOrderDetailByIdInputPort {
    OrderDetailDomainEntity getById(Integer id);
}
