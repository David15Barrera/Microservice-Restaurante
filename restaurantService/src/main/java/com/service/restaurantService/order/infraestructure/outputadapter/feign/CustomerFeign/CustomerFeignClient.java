package com.service.restaurantService.order.infraestructure.outputadapter.feign.CustomerFeign;

import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.CustomerResponse;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.Fallback.CustomerFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customerClient", url = "http://localhost:8081/api/auth-identity", fallbackFactory = CustomerFeignClientFallbackFactory.class)
public interface CustomerFeignClient {

    @GetMapping("/api/v1/customers/{id}")
    CustomerResponse getCustomerById(@PathVariable("id") String id);
}