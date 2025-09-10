package com.service.restaurantService.order.infraestructure.outputadapter.feign.Fallback;

import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.PromotionResponse;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.PromotionFeign.PromotionsFeignClient;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class PromotionsFeignClientFallbackFactory implements FallbackFactory<PromotionsFeignClient> {

    @Override
    public  PromotionsFeignClient create(Throwable cause){
        return new PromotionsFeignClient() {
            @Override
            public PromotionResponse getPromotionById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                } else {
                    System.err.println("Other error: " + cause.getMessage());
                }

                PromotionResponse fallbackResponse = new PromotionResponse();
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
