package com.service.restaurantService.order.application.usecase.delete;

import com.service.restaurantService.order.application.ports.input.DeleteOrderInputPort;
import com.service.restaurantService.order.application.ports.output.DeleteOrderOutputPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteOrderUseCase implements DeleteOrderInputPort {

    private final DeleteOrderOutputPort outputPort;

    public DeleteOrderUseCase(DeleteOrderOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void deleteById(UUID id) {
        outputPort.deleteById(id);
    }
}
