package com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.PromotionFeign;

import com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.dto.PromotionResponse;
import com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.fallback.PromotionFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "promotionClient", url = "http://localhost:8086/api/promotion", fallbackFactory = PromotionFeignClientFallbackFactory.class)
public interface PromotionFeignClient {
    @GetMapping("/api/v1/promotions/{id}")
    PromotionResponse getPromotionById(@PathVariable("id") UUID id);

}
