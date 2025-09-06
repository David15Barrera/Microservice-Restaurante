package com.service.restaurantService.restaurant.infrastructure.outputadapter.feign;

import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.HotelResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HotelFeignClientFallback implements HotelFeignClient{

    @Override
    public HotelResponse getHotelById(UUID id) {
        HotelResponse fallbackResponse = new HotelResponse();

        fallbackResponse.id = id;
        fallbackResponse.name = "Servicio de Clientes no disponible";

        return fallbackResponse;
    }
}
