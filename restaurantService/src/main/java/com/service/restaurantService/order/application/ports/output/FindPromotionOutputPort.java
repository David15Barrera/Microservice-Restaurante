package com.service.restaurantService.order.application.ports.output;

import com.service.restaurantService.order.domain.model.PromotionDomainEntity;

import java.util.UUID;

public interface FindPromotionOutputPort {
    PromotionDomainEntity findById(UUID id);
}
