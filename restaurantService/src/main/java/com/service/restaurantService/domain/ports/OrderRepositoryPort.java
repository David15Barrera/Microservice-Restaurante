package com.service.restaurantService.domain.ports;

import com.service.restaurantService.domain.model.order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepositoryPort {
    order save(order order);
    Optional<order> findById(Integer id);
    List<order> findAll();
    List<order> findByRestaurantId(UUID restaurantId);
    void deleteById(Integer id);
}
