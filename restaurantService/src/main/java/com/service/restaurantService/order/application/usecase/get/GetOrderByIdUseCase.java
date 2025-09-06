package com.service.restaurantService.order.application.usecase.get;

import com.service.restaurantService.order.application.ports.input.GetOrderByIdInputPort;
import com.service.restaurantService.order.application.ports.output.FindCustomerOutputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.CustomerDomainEntity;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class GetOrderByIdUseCase implements GetOrderByIdInputPort {

    private final SaveOrderOutputPort outputPort;
    private final FindCustomerOutputPort customerOutputPort;

    public GetOrderByIdUseCase(SaveOrderOutputPort outputPort,
                               FindCustomerOutputPort customerOutputPort) {
        this.outputPort = outputPort;
        this.customerOutputPort = customerOutputPort;
    }


    @Override
    public OrderDomainEntity getById(Integer id) {
        OrderDomainEntity order = outputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        CustomerDomainEntity customer = customerOutputPort.findById(order.getCustomerId());

        // Enriquecemos la orden con el customer
        order.setCustomer(customer);

        return order;
    }
}
