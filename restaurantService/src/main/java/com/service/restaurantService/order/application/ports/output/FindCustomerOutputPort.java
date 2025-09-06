package com.service.restaurantService.order.application.ports.output;

import com.service.restaurantService.order.domain.model.CustomerDomainEntity;

import java.util.UUID;

public interface FindCustomerOutputPort {
    CustomerDomainEntity findById(UUID id);
}
