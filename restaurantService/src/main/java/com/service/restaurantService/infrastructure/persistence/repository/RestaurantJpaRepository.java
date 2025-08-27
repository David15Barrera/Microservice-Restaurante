package com.service.restaurantService.infrastructure.persistence.repository;

import com.service.restaurantService.infrastructure.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, UUID> {

}
