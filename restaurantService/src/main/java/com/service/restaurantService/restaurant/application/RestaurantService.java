package com.service.restaurantService.restaurant.application;

import com.service.restaurantService.restaurant.domain.model.Restaurant;
import com.service.restaurantService.restaurant.domain.port.RestaurantRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {
    private final RestaurantRepositoryPort repo;
    public RestaurantService(RestaurantRepositoryPort repo){
        this.repo=repo;
    }

    public Restaurant create(Restaurant r){
        return repo.save(r);
    }

    public Optional<Restaurant> get(UUID id){
        return repo.findById(id);
    }

    public List<Restaurant> list(){
        return repo.findAll();
    }

    public Restaurant update(Restaurant r){
        return repo.save(r);
    }

    public void delete(UUID id){
        repo.deleteById(id);
    }
}
