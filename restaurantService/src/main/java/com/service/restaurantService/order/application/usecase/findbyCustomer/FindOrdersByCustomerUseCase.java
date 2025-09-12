package com.service.restaurantService.order.application.usecase.findbyCustomer;

import com.service.restaurantService.order.application.ports.input.FindOrderByCustomerInputPort;
import com.service.restaurantService.order.application.ports.output.FindOrdersByCustomerOutPort;
import com.service.restaurantService.order.application.ports.output.FindOrdersByRestaurantOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindOrdersByCustomerUseCase implements FindOrderByCustomerInputPort {

    private final FindOrdersByCustomerOutPort outputPort;

    public FindOrdersByCustomerUseCase(FindOrdersByCustomerOutPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public List<OrderDomainEntity> findByCustomer(UUID customerId) {
        List<OrderDomainEntity> orders = outputPort.findByCustomer(customerId);
        return orders;
    }
}