package com.service.restaurantService.infrastructure.persistence.repository;

import com.service.restaurantService.infrastructure.persistence.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailJpaRepository extends JpaRepository<OrderDetailEntity, Integer> {
    List<OrderDetailEntity> findByOrderId(Integer orderId);
}
