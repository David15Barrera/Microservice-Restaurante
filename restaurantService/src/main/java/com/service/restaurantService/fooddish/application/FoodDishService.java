package com.service.restaurantService.fooddish.application;

import com.service.restaurantService.fooddish.domain.model.FoodDish;
import com.service.restaurantService.fooddish.domain.port.FoodDishRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class FoodDishService {
    private final FoodDishRepositoryPort repo;

    public FoodDishService(FoodDishRepositoryPort repo){
        this.repo=repo;
    }

    public FoodDish create(FoodDish d){
        return repo.save(d);
    }

    public Optional<FoodDish> get(Integer id){
        return repo.findById(id);
    }

    public List<FoodDish> list(){
        return repo.findAll();
    }

    public List<FoodDish> listByRestaurant(UUID r){
        return repo.findByRestaurantId(r);
    }

    public FoodDish update(FoodDish d){
        return repo.save(d);
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}
