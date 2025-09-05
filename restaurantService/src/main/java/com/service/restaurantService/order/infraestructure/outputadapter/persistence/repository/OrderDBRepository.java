package com.service.restaurantService.order.infraestructure.outputadapter.persistence.repository;

import com.service.restaurantService.order.infraestructure.outputadapter.persistence.entity.OrderDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDBRepository extends JpaRepository<OrderDBEntity, Integer> {
}
