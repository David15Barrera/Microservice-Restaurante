package com.service.restaurantService.order.application.usecase.listhotels;

import com.service.restaurantService.order.application.ports.input.ListAllOrderInputPort;
import com.service.restaurantService.order.application.ports.output.FindCustomerOutputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllOrderUseCase implements ListAllOrderInputPort {

    private final SaveOrderOutputPort outputPort;
    private final FindCustomerOutputPort customerOutputPort;

    public ListAllOrderUseCase(SaveOrderOutputPort outputPort,
                               FindCustomerOutputPort customerOutputPort) {
        this.outputPort = outputPort;
        this.customerOutputPort = customerOutputPort;
    }

    @Override
    public List<OrderDomainEntity> listAll() {

        List<OrderDomainEntity> orders = outputPort.findAll();

        // Enriquecer cada orden con los datos del cliente
        for (OrderDomainEntity order : orders) {
            order.setCustomer(customerOutputPort.findById(order.getCustomerId()));
        }

        return orders;
    }
}
