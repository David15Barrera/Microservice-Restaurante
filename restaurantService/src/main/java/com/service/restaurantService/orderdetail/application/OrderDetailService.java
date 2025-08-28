package com.service.restaurantService.orderdetail.application;

import com.service.restaurantService.orderdetail.domain.model.OrderDetail;
import com.service.restaurantService.orderdetail.domain.port.OrderDetailRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service public class OrderDetailService {
    private final OrderDetailRepositoryPort repo;

    public OrderDetailService(OrderDetailRepositoryPort repo){
        this.repo=repo;
    }
    public OrderDetail create(OrderDetail d){
        if (d.getSubtotal()==null && d.getUnitPrice()!=null && d.getQuantity()!=null)
            d.setSubtotal(
                    d.getUnitPrice().multiply(java.math.BigDecimal.valueOf(
                            d.getQuantity())));
        return repo.save(d);
    }
    public Optional<OrderDetail> get(Integer id){
        return repo.findById(id);
    }

    public List<OrderDetail> list(){
        return repo.findAll();
    }

    public List<OrderDetail> listByOrder(Integer orderId){
        return repo.findByOrderId(orderId);
    }

    public OrderDetail update(OrderDetail d){
        return repo.save(d);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
