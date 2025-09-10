package com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.fallback;

import com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.dto.PromotionResponse;
import com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.PromotionFeign.PromotionFeignClient;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.UUID;

public class PromotionFeignClientFallbackFactory implements FallbackFactory<PromotionFeignClient> {

    @Override
    public PromotionFeignClient create(Throwable cause){
        return new PromotionFeignClient() {
            @Override
            public PromotionResponse getPromotionById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                } else {
                    System.err.println("Other error: " + cause.getMessage());
                }

                PromotionResponse fallbackResponse = new PromotionResponse();
                fallbackResponse.id = id;
                fallbackResponse.name = "Servicio de Promotions no disponible";
                fallbackResponse.description = "Información de promoción no pudo ser obtenida.";
                fallbackResponse.startDate = null;
                fallbackResponse.endDate = null;
                fallbackResponse.hotelId = null;
                fallbackResponse.restaurantId = null;
                fallbackResponse.customerId = null;
                fallbackResponse.roomId = null;
                fallbackResponse.dishId = null;

                return fallbackResponse;
            }
        };
    }
}
