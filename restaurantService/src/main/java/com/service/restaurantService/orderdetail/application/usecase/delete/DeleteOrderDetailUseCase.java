package com.service.restaurantService.orderdetail.application.usecase.delete;

import com.service.restaurantService.orderdetail.application.ports.input.DeleteOrderDetailInputPort;
import com.service.restaurantService.orderdetail.application.ports.output.SaveOrderDetailOutputPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteOrderDetailUseCase implements DeleteOrderDetailInputPort {
    private final SaveOrderDetailOutputPort outputPort;
    public DeleteOrderDetailUseCase(SaveOrderDetailOutputPort outputPort){this.outputPort=outputPort;}
    @Override public void deleteById(Integer id){ outputPort.deleteById(id); }
}
