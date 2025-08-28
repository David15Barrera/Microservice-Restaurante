package com.service.restaurantService.orderdetail.domain.port;


import com.service.restaurantService.orderdetail.domain.model.OrderDetail;

import java.util.List;
import java.util.Optional;
public interface OrderDetailRepositoryPort {
    OrderDetail save(OrderDetail d);
    Optional<OrderDetail> findById(Integer id);
    List<OrderDetail> findByOrderId(Integer orderId);
    List<OrderDetail> findAll();
    void deleteById(Integer id);
}
