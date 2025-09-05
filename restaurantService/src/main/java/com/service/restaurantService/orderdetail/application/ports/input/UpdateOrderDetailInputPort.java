package com.service.restaurantService.orderdetail.application.ports.input;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;

public interface UpdateOrderDetailInputPort { OrderDetailDomainEntity update(OrderDetailDomainEntity d); }
