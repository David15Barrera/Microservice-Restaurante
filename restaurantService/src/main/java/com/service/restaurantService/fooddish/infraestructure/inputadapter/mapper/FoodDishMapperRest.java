package com.service.restaurantService.fooddish.infraestructure.inputadapter.mapper;

import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import com.service.restaurantService.fooddish.infraestructure.inputadapter.dto.FoodDishRequestDto;
import com.service.restaurantService.fooddish.infraestructure.inputadapter.dto.FoodDishResponseDto;

public class FoodDishMapperRest {
    public static FoodDishResponseDto toResponse(FoodDishDomainEntity d) {
        if (d == null) return null;
        FoodDishResponseDto r = new FoodDishResponseDto();
        r.id = d.getId();
        r.restaurantId = d.getRestaurantId();
        r.name = d.getName();
        r.description = d.getDescription();
        r.price = d.getPrice();
        r.createdAt = d.getCreatedAt();
        return r;
    }

    public static FoodDishDomainEntity toDomain(FoodDishRequestDto dto) {
        if (dto == null) return null;
        FoodDishDomainEntity d = new FoodDishDomainEntity();
        d.setRestaurantId(dto.restaurantId);
        d.setName(dto.name);
        d.setDescription(dto.description);
        d.setPrice(dto.price);
        return d;
    }
}
