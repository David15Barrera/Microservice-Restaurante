package com.service.restaurantService.adapters.outPort.persistance.repository;

import com.service.restaurantService.adapters.outPort.persistance.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DishJpaRepository extends JpaRepository<DishEntity, Integer> {
    List<DishEntity> findByRestaurantId(UUID restaurantId);
}
