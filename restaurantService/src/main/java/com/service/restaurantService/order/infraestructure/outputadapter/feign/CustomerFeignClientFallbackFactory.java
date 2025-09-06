package com.service.restaurantService.order.infraestructure.outputadapter.feign;

import com.service.restaurantService.order.infraestructure.inputadapter.dto.CustomerResponse;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerFeignClientFallbackFactory implements FallbackFactory<CustomerFeignClient> {

    @Override
    public CustomerFeignClient create(Throwable cause) {
        return new CustomerFeignClient() {
            @Override
            public CustomerResponse getCustomerById(String id) {
                // If the cause is a network issue, provide a specific fallback
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                    CustomerResponse fallbackResponse = new CustomerResponse();
                    fallbackResponse.id = id;
                    fallbackResponse.fullName = "Servicio de Clientes no disponible (Error de conexión)";
                    return fallbackResponse;
                }

                // For all other errors, use a generic fallback
                System.err.println("Other error: " + cause.getMessage());
                CustomerResponse fallbackResponse = new CustomerResponse();
                fallbackResponse.id = id;
                fallbackResponse.fullName = "Servicio de Clientes no disponible (Error genérico)";
                return fallbackResponse;
            }
        };
    }
}