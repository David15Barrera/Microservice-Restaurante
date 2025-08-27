package com.service.restaurantService.domain.port.out;

import com.service.restaurantService.domain.model.Order;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepositoryPort {
    Order save(Order order);
    Optional<Order> findById(Integer id);
    List<Order> findByRestaurantAndDateRange(UUID restaurantId, Instant from, Instant to);
    List<Order> findByCustomerAndDateRange(UUID customerId, Instant from, Instant to);
    List<Order> findAll();
    void deleteById(Integer id);
}
