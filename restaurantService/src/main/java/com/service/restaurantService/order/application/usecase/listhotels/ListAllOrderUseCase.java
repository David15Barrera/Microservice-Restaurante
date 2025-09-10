package com.service.restaurantService.order.application.usecase.listhotels;

import com.service.restaurantService.order.application.ports.input.ListAllOrderInputPort;
import com.service.restaurantService.order.application.ports.output.FindCustomerOutputPort;
import com.service.restaurantService.order.application.ports.output.FindPromotionOutputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllOrderUseCase implements ListAllOrderInputPort {

    private final SaveOrderOutputPort outputPort;
    private final FindCustomerOutputPort customerOutputPort;
    private final FindPromotionOutputPort promotionOutputPort;

    public ListAllOrderUseCase(SaveOrderOutputPort outputPort,
                               FindCustomerOutputPort customerOutputPort,
                               FindPromotionOutputPort promotionOutputPort) {
        this.outputPort = outputPort;
        this.customerOutputPort = customerOutputPort;
        this.promotionOutputPort = promotionOutputPort;
    }

    @Override
    public List<OrderDomainEntity> listAll() {
        List<OrderDomainEntity> orders = outputPort.findAll();

        return orders;
    }
}
