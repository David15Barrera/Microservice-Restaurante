package com.service.restaurantService.orderdetail.application.usecase.get;

import com.service.restaurantService.orderdetail.application.ports.input.GetOrderDetailByIdInputPort;
import com.service.restaurantService.orderdetail.application.ports.output.SaveOrderDetailOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class GetOrderDetailByIdUseCase implements GetOrderDetailByIdInputPort {
    private final SaveOrderDetailOutputPort outputPort;
    public GetOrderDetailByIdUseCase(SaveOrderDetailOutputPort outputPort){this.outputPort=outputPort;}
    @Override public OrderDetailDomainEntity getById(Integer id){ return outputPort.findById(id).orElseThrow(()->new IllegalArgumentException("OrderDetail not found")); }
}
