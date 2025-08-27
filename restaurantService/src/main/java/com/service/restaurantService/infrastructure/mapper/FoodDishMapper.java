package com.service.restaurantService.infrastructure.mapper;


import com.service.restaurantService.domain.model.FoodDish;
import com.service.restaurantService.infrastructure.persistence.entity.FoodDishEntity;

public class FoodDishMapper {
    public static FoodDishEntity toEntity(FoodDish d) {
        FoodDishEntity e = new FoodDishEntity();
        e.setId(d.getId());
        e.setRestaurantId(d.getRestaurantId());
        e.setName(d.getName());
        e.setDescription(d.getDescription());
        e.setPrice(d.getPrice());
        return e;
    }
    public static FoodDish toDomain(FoodDishEntity e) {
        return new FoodDish(e.getId(), e.getRestaurantId(), e.getName(), e.getDescription(), e.getPrice());
    }
}
