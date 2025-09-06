package com.service.restaurantService.order.application.usecase.findbyrestaurant;

import com.service.restaurantService.order.application.ports.input.FindOrdersByRestaurantInputPort;
import com.service.restaurantService.order.application.ports.output.FindCustomerOutputPort;
import com.service.restaurantService.order.application.ports.output.FindOrdersByRestaurantOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindOrdersByRestaurantUseCase implements FindOrdersByRestaurantInputPort {

    private final FindOrdersByRestaurantOutputPort outputPort;
    private final FindCustomerOutputPort customerOutputPort;

    public FindOrdersByRestaurantUseCase(FindOrdersByRestaurantOutputPort outputPort,
                                         FindCustomerOutputPort customerOutputPort) {
        this.outputPort = outputPort;
        this.customerOutputPort = customerOutputPort;
    }

    @Override
    public List<OrderDomainEntity> findByRestaurantId(UUID restaurantId) {
        List<OrderDomainEntity> orders = outputPort.findByRestaurantId(restaurantId);
        orders.forEach(order -> {
            order.setCustomer(customerOutputPort.findById(order.getCustomerId()));
        });

        return orders;
    }
}