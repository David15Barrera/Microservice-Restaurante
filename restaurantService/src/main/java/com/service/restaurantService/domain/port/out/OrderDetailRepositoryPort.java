package com.service.restaurantService.domain.port.out;


import com.service.restaurantService.domain.model.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepositoryPort {
    OrderDetail save(OrderDetail detail);
    Optional<OrderDetail> findById(Integer id);
    List<OrderDetail> findByOrderId(Integer orderId);
    void deleteById(Integer id);
}
