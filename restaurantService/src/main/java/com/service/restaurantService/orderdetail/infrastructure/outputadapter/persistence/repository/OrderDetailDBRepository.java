package com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.repository;

import com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.entity.OrderDetailDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDetailDBRepository extends JpaRepository<OrderDetailDBEntity, Integer> {
    List<OrderDetailDBEntity> findByOrderId(UUID orderId);
}
