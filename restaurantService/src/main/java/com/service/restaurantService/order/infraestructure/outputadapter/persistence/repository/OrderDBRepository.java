package com.service.restaurantService.order.infraestructure.outputadapter.persistence.repository;

import com.service.restaurantService.order.infraestructure.outputadapter.persistence.entity.OrderDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDBRepository extends JpaRepository<OrderDBEntity, UUID> {
    List<OrderDBEntity> findByRestaurantId(UUID restaurantId);
    List<OrderDBEntity> findByCustomerId(UUID customerId);
}
