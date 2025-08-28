package com.service.restaurantService.order.domain.port;

import com.service.restaurantService.order.domain.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface OrderRepositoryPort {
    Order save(Order o);
    Optional<Order> findById(Integer id);
    List<Order> findAll();
    List<Order> findByRestaurantId(UUID restaurantId);
    void deleteById(Integer id);
}
