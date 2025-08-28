package com.service.restaurantService.fooddish.adapters.in.web;

import com.service.restaurantService.fooddish.adapters.in.web.dto.FoodDishRequest;
import com.service.restaurantService.fooddish.adapters.in.web.dto.FoodDishResponse;
import com.service.restaurantService.fooddish.domain.model.FoodDish;

public class FoodDishMapper {
    public static FoodDish toDomain(FoodDishRequest req){
        FoodDish d=new FoodDish();
        d.setRestaurantId(req.restaurantId);
        d.setName(req.name);
        d.setDescription(req.description);
        d.setPrice(req.price);
        return d;
    }

    public static FoodDishResponse toResponse(FoodDish d){
        FoodDishResponse r=new FoodDishResponse();
        r.id=d.getId();
        r.restaurantId=d.getRestaurantId();
        r.name=d.getName();
        r.description=d.getDescription();
        r.price=d.getPrice();
        return r;
    }
}
