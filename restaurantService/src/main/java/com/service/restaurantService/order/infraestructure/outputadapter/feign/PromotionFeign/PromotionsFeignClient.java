package com.service.restaurantService.order.infraestructure.outputadapter.feign.PromotionFeign;


import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.PromotionResponse;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.Fallback.PromotionsFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "promotionsClient", url = "https://microservice-promotions-12sn.onrender.com/api/promotion", fallbackFactory = PromotionsFeignClientFallbackFactory.class)
public interface PromotionsFeignClient {

    @GetMapping("/api/v1/promotions/{id}")
    PromotionResponse getPromotionById(@PathVariable("id") UUID id);
}
