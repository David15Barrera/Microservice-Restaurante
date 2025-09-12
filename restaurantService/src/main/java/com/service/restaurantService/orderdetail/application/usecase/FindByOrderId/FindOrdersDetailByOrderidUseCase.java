package com.service.restaurantService.orderdetail.application.usecase.FindByOrderId;

import com.service.restaurantService.orderdetail.application.ports.input.FindOrderDetailByOrderIdInputPort;
import com.service.restaurantService.orderdetail.application.ports.output.FindOrderDetailByOrderIdOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindOrdersDetailByOrderidUseCase implements FindOrderDetailByOrderIdInputPort {

    private final FindOrderDetailByOrderIdOutputPort outputPort;

    public FindOrdersDetailByOrderidUseCase(FindOrderDetailByOrderIdOutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public List<OrderDetailDomainEntity> findByOrderId(UUID orderId) {
        List<OrderDetailDomainEntity> orders = outputPort.findByOrderId(orderId);
        return orders;
    }

}
