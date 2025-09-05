package com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.mapper;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.entity.FoodDishDBEntity;

public class FoodDishMapper {
    public static FoodDishDomainEntity toDomain(FoodDishDBEntity e) {
        if (e == null) return null;
        FoodDishDomainEntity d = new FoodDishDomainEntity();
        d.setId(e.getId());
        d.setRestaurantId(e.getRestaurantId());
        d.setName(e.getName());
        d.setDescription(e.getDescription());
        d.setPrice(e.getPrice());
        d.setCreatedAt(e.getCreatedAt());
        return d;
    }

    public static FoodDishDBEntity toEntity(FoodDishDomainEntity d) {
        if (d == null) return null;
        FoodDishDBEntity e = new FoodDishDBEntity();
        e.setId(d.getId());
        e.setRestaurantId(d.getRestaurantId());
        e.setName(d.getName());
        e.setDescription(d.getDescription());
        e.setPrice(d.getPrice());
        e.setCreatedAt(d.getCreatedAt());
        return e;
    }
}
