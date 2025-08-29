package com.service.restaurantService.fooddish.adapters.out.persistence;

import com.service.restaurantService.fooddish.domain.model.FoodDish;
import com.service.restaurantService.fooddish.domain.port.FoodDishRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FoodDishRepositoryAdapter implements FoodDishRepositoryPort {
    private final FoodDishJpaRepository jpa;

    public FoodDishRepositoryAdapter(FoodDishJpaRepository jpa){
        this.jpa=jpa;
    }

    private static FoodDish toDomain(FoodDishEntity e){
        if(e==null) return null;
        FoodDish d=new FoodDish();
        d.setId(e.getId());
        d.setRestaurantId(e.getRestaurantId());
        d.setName(e.getName());
        d.setDescription(e.getDescription());
        d.setPrice(e.getPrice());
        return d;
    }

    private static FoodDishEntity toEntity(FoodDish d){
        if(d==null) return null;
        FoodDishEntity e=new FoodDishEntity();
        e.setId(d.getId());
        e.setRestaurantId(d.getRestaurantId());
        e.setName(d.getName());
        e.setDescription(d.getDescription());
        e.setPrice(d.getPrice());
        return e;
    }

    @Override
    public FoodDish save(FoodDish d){
        return toDomain(jpa.save(toEntity(d)));
    }

    @Override
    public Optional<FoodDish> findById(Integer id) {
        return jpa.findById(id).map(FoodDishRepositoryAdapter::toDomain);
    }

    @Override
    public List<FoodDish> findByRestaurantId(UUID restaurantId){
        return jpa.findByRestaurantId(restaurantId).stream().map(FoodDishRepositoryAdapter::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<FoodDish> findAll(){
        return jpa.findAll().stream().map(FoodDishRepositoryAdapter::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id){
        jpa.deleteById(id);
    }
}
