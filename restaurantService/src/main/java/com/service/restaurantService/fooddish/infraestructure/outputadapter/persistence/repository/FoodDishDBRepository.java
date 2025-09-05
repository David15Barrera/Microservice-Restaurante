package com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.repository;

import com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.entity.FoodDishDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDishDBRepository extends JpaRepository<FoodDishDBEntity, Integer> {


}
