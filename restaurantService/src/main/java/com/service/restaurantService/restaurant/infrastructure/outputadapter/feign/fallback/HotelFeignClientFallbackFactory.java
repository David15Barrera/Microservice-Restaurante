package com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.fallback;

import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.dto.HotelResponse;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.HotelFeign.HotelFeignClient;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.UUID;

public class HotelFeignClientFallbackFactory  implements FallbackFactory<HotelFeignClient> {

    @Override
    public HotelFeignClient create(Throwable cause) {
        return new HotelFeignClient() {
            @Override
            public HotelResponse getHotelById(UUID id) {
                // If the cause is a network issue, provide a specific fallback
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                    HotelResponse fallbackResponse = new HotelResponse();
                    fallbackResponse.id = id;
                    fallbackResponse.name = "Servicio de Hoteles no disponible (Error de conexión)";
                    return fallbackResponse;
                }

                // For all other errors, use a generic fallback
                System.err.println("Other error: " + cause.getMessage());
                HotelResponse fallbackResponse = new HotelResponse();
                fallbackResponse.id = id;
                fallbackResponse.name = "Servicio de Hotel no disponible (Error genérico)";
                return fallbackResponse;
            }
        };
    }
}
