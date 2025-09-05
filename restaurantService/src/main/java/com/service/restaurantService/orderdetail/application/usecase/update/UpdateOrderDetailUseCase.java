package com.service.restaurantService.orderdetail.application.usecase.update;

import com.service.restaurantService.orderdetail.application.ports.input.UpdateOrderDetailInputPort;
import com.service.restaurantService.orderdetail.application.ports.output.SaveOrderDetailOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderDetailUseCase implements UpdateOrderDetailInputPort {

    private final SaveOrderDetailOutputPort outputPort;

    public UpdateOrderDetailUseCase(SaveOrderDetailOutputPort outputPort) { this.outputPort = outputPort; }

    @Override public OrderDetailDomainEntity update(OrderDetailDomainEntity d) {
        if (d.getId() == null) throw new IllegalArgumentException("id required for update");
        if (d.getQuantity() != null && d.getUnitPrice() != null) {
            d.setSubtotal(d.getUnitPrice().multiply(new java.math.BigDecimal(d.getQuantity())));
        }
        return outputPort.save(d);
    }
}
