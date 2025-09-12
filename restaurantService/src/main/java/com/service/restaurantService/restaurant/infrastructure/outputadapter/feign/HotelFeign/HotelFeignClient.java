package com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.HotelFeign;

import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.dto.HotelResponse;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.feign.fallback.HotelFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "hotelClient", url = "https://microservice-hotel.onrender.com/api/hotel", fallbackFactory = HotelFeignClientFallbackFactory.class)
public interface HotelFeignClient {

    @GetMapping("/api/v1/hotels/{id}")
    HotelResponse getHotelById(@PathVariable("id") UUID id);

}
