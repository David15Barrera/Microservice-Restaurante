package com.service.restaurantService.domain.ports;

import com.service.restaurantService.domain.model.orderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepositoryPort {
    orderDetail save(orderDetail detail);
    Optional<orderDetail> findById(Integer id);
    List<orderDetail> findByOrderId(Integer orderId);
    List<orderDetail> findAll();
    void deleteById(Integer id);
}
