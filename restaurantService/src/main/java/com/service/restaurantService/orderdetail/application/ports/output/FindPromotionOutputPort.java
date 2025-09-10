package com.service.restaurantService.orderdetail.application.ports.output;

import com.service.restaurantService.orderdetail.domain.model.PromotionDomainEntity;

    import java.util.UUID;

    public interface FindPromotionOutputPort {
        PromotionDomainEntity findById(UUID id);
    }
