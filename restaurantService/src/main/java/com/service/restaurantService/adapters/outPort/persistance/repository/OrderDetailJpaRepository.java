package com.service.restaurantService.adapters.outPort.persistance.repository;

import com.service.restaurantService.adapters.outPort.persistance.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailJpaRepository extends JpaRepository<OrderDetailEntity, Integer> {
    List<OrderDetailEntity> findByOrderId(Integer orderId);
}
