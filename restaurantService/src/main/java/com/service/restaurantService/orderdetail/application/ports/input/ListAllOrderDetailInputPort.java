package com.service.restaurantService.orderdetail.application.ports.input;

import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;

import java.util.List;

public interface ListAllOrderDetailInputPort { List<OrderDetailDomainEntity> listAll(); }
