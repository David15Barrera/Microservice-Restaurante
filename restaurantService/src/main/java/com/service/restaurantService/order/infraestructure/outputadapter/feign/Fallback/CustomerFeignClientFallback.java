package com.service.restaurantService.order.infraestructure.outputadapter.feign.Fallback;

import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.CustomerResponse;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.CustomerFeign.CustomerFeignClient;
import org.springframework.stereotype.Component;

@Component
public class CustomerFeignClientFallback implements CustomerFeignClient {

    @Override
    public CustomerResponse getCustomerById(String id) {
        CustomerResponse fallbackResponse = new CustomerResponse();
        fallbackResponse.id = id;
        fallbackResponse.fullName = "Servicio de Clientes no disponible";
        return fallbackResponse;
    }
}
