package com.service.restaurantService.adapters.outPort.persistance.repository;


import com.service.restaurantService.adapters.outPort.persistance.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, UUID> {}
