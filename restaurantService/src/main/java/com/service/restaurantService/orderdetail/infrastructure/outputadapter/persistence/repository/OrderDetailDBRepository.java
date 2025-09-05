package com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.repository;

import com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.entity.OrderDetailDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDBRepository extends JpaRepository<OrderDetailDBEntity, Integer> { }
