package com.service.restaurantService.order.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByRestaurantId(UUID restaurantId);
}
