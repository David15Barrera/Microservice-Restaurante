package com.service.restaurantService.order.application.usecase.get;

import com.service.restaurantService.order.application.ports.input.GetOrderByIdInputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOrderByIdUseCase implements GetOrderByIdInputPort {

    private final SaveOrderOutputPort outputPort;

    public GetOrderByIdUseCase(SaveOrderOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public OrderDomainEntity getById(Integer id) {
        Optional<OrderDomainEntity> o = outputPort.findById(id);
        return o.orElse(null);
    }
}
