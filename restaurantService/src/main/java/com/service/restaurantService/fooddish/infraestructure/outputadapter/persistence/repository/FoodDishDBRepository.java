package com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.repository;

import com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.entity.FoodDishDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodDishDBRepository extends JpaRepository<FoodDishDBEntity, Integer> {
    List<FoodDishDBEntity> findByRestaurantId(UUID restaurantId);

}
