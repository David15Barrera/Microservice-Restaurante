package com.service.restaurantService.order.application.usecase.update;

import com.service.restaurantService.order.application.ports.input.UpdateOrderInputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderUseCase implements UpdateOrderInputPort {

    private final SaveOrderOutputPort outputPort;

    public UpdateOrderUseCase(SaveOrderOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public OrderDomainEntity update(OrderDomainEntity order) {
        return outputPort.save(order);
    }
}
