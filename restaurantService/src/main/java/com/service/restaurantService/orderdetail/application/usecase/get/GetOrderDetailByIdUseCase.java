package com.service.restaurantService.orderdetail.application.usecase.get;

import com.service.restaurantService.orderdetail.application.ports.input.GetOrderDetailByIdInputPort;
import com.service.restaurantService.orderdetail.application.ports.output.FindPromotionOutputPort;
import com.service.restaurantService.orderdetail.application.ports.output.SaveOrderDetailOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import com.service.restaurantService.orderdetail.domain.model.PromotionDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class GetOrderDetailByIdUseCase implements GetOrderDetailByIdInputPort {
    private final SaveOrderDetailOutputPort outputPort;

    public GetOrderDetailByIdUseCase(SaveOrderDetailOutputPort outputPort){
        this.outputPort=outputPort;
    }

    @Override
    public OrderDetailDomainEntity getById(Integer id){
        OrderDetailDomainEntity order = outputPort.findById(id)
                .orElseThrow(()->new IllegalArgumentException("OrderDetail not found"));
        return order;
    }
}
