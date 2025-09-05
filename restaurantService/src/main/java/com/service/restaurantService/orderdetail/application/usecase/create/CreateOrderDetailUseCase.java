package com.service.restaurantService.orderdetail.application.usecase.create;

import com.service.restaurantService.orderdetail.application.ports.input.CreateOrderDetailInputPort;
import com.service.restaurantService.orderdetail.application.ports.output.SaveOrderDetailOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateOrderDetailUseCase implements CreateOrderDetailInputPort {

    private final SaveOrderDetailOutputPort outputPort;

    public CreateOrderDetailUseCase(SaveOrderDetailOutputPort outputPort) { this.outputPort = outputPort; }

    @Override public OrderDetailDomainEntity create(OrderDetailDomainEntity d) {
        if (d.getOrderId() == null) throw new IllegalArgumentException("orderId required");
        if (d.getQuantity() == null || d.getQuantity() <= 0) throw new IllegalArgumentException("quantity must be > 0");
        if (d.getUnitPrice() == null) d.setUnitPrice(BigDecimal.ZERO);
        if (d.getUnitCost() == null) d.setUnitCost(BigDecimal.ZERO);
        d.setSubtotal(d.getUnitPrice().multiply(new BigDecimal(d.getQuantity())));
        return outputPort.save(d);
    }
}
