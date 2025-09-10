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

    public FindOrdersByRestaurantUseCase(FindOrdersByRestaurantOutputPort outputPort
                                         ) {
        this.outputPort = outputPort;
    }

    @Override
    public List<OrderDomainEntity> findByRestaurantId(UUID restaurantId) {
        List<OrderDomainEntity> orders = outputPort.findByRestaurantId(restaurantId);

        return orders;
    }

}