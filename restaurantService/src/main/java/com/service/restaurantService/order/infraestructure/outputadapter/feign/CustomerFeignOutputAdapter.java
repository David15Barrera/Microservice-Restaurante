package com.service.restaurantService.order.infraestructure.outputadapter.feign;

import com.service.restaurantService.order.application.ports.output.FindCustomerOutputPort;
import com.service.restaurantService.order.domain.model.CustomerDomainEntity;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.CustomerResponse;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.CustomerFeign.CustomerFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class CustomerFeignOutputAdapter implements FindCustomerOutputPort {

    private final CustomerFeignClient client;

    public CustomerFeignOutputAdapter(CustomerFeignClient client) {
        this.client = client;
    }

    @Override
    public CustomerDomainEntity findById(UUID id) {
        CustomerResponse response = client.getCustomerById(id.toString());

        CustomerDomainEntity domain = new CustomerDomainEntity();
        domain.setId(UUID.fromString(response.id));
        domain.setFullName(response.fullName);
        domain.setCui(response.cui);
        domain.setPhone(response.phone);
        domain.setEmail(response.email);
        domain.setAddress(response.address);
        domain.setLoyaltyPoints(response.loyaltyPoints);

        return domain;
    }
}