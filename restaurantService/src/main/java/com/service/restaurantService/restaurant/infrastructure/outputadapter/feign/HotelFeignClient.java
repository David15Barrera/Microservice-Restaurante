package com.service.restaurantService.restaurant.infrastructure.outputadapter.feign;

import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.HotelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "hotelClient", url = "http://localhost:8082/api/hotel", fallbackFactory = HotelFeignClientFallbackFactory.class)
public interface HotelFeignClient {

    @GetMapping("/api/v1/hotels/{id}")
    HotelResponse getHotelById(@PathVariable("id") UUID id);
}
