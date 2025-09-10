package com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.fallback;

import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.dto.HotelResponse;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.HotelFeign.HotelFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HotelFeignClientFallback implements HotelFeignClient {

    @Override
    public HotelResponse getHotelById(UUID id) {
        HotelResponse fallbackResponse = new HotelResponse();

        fallbackResponse.id = id;
        fallbackResponse.name = "Servicio de Clientes no disponible";

        return fallbackResponse;
    }
}
