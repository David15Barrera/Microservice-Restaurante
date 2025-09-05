package com.service.restaurantService.orderdetail.application.usecase.listhotels;

import com.service.restaurantService.orderdetail.application.ports.input.ListAllOrderDetailInputPort;
import com.service.restaurantService.orderdetail.application.ports.output.SaveOrderDetailOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllOrderDetailUseCase implements ListAllOrderDetailInputPort {
    private final SaveOrderDetailOutputPort outputPort;
    public ListAllOrderDetailUseCase(SaveOrderDetailOutputPort outputPort){this.outputPort=outputPort;}
    @Override public List<OrderDetailDomainEntity> listAll(){ return outputPort.findAll(); }
}
