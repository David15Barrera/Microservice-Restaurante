package com.service.restaurantService.adapters.outPort.persistance.repository;

import com.service.restaurantService.adapters.outPort.persistance.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByRestaurantId(UUID restaurantId);
}
