package com.service.restaurantService.order.application.usecase.create;

import com.service.restaurantService.order.application.ports.input.CreateOrderInputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateOrderUseCase implements CreateOrderInputPort {

    private final SaveOrderOutputPort outputPort;

    public CreateOrderUseCase(SaveOrderOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public OrderDomainEntity create(OrderDomainEntity order) {
        order.setId(UUID.randomUUID());
        return outputPort.save(order);
    }
}
