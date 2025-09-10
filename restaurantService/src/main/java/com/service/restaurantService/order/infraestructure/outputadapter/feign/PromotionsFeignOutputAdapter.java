package com.service.restaurantService.order.infraestructure.outputadapter.feign;

import com.service.restaurantService.order.application.ports.output.FindPromotionOutputPort;
import com.service.restaurantService.order.domain.model.PromotionDomainEntity;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.PromotionResponse;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.PromotionFeign.PromotionsFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class PromotionsFeignOutputAdapter implements FindPromotionOutputPort {

    private  final PromotionsFeignClient client;

    public PromotionsFeignOutputAdapter(PromotionsFeignClient client){
        this.client = client;
    }

    @Override
    public PromotionDomainEntity findById(UUID id){
        PromotionResponse response = client.getPromotionById(id);

        PromotionDomainEntity domain = new PromotionDomainEntity();
        domain.setId(response.id);
        domain.setName(response.name);
        domain.setDescription(response.description);
        domain.setType(response.type);
        domain.setDiscountPercentage(response.discountPercentage);
        domain.setStartDate(response.startDate);
        domain.setEndDate(response.endDate);
        domain.setHotelId(response.hotelId);
        domain.setRestaurantId(response.restaurantId);
        domain.setCustomerId(response.customerId);
        domain.setRoomId(response.roomId);
        domain.setDishId(response.dishId);

        return domain;
    }
}
