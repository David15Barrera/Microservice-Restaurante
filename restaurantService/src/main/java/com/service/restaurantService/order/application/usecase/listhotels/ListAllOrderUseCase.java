package com.service.restaurantService.order.application.usecase.listhotels;

import com.service.restaurantService.order.application.ports.input.ListAllOrderInputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllOrderUseCase implements ListAllOrderInputPort {

    private final SaveOrderOutputPort outputPort;

    public ListAllOrderUseCase(SaveOrderOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public List<OrderDomainEntity> listAll() {
        return outputPort.findAll();
    }
}
