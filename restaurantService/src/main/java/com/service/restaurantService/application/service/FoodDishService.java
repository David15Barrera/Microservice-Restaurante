package com.service.restaurantService.application.service;

import com.service.restaurantService.application.dto.FoodDishDTO;
import com.service.restaurantService.domain.model.FoodDish;
import com.service.restaurantService.domain.port.out.FoodDishRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodDishService {
    private final FoodDishRepositoryPort repository;

    public FoodDishService(FoodDishRepositoryPort repository) {
        this.repository = repository;
    }

    public FoodDishDTO create(FoodDishDTO dto) {
        return map(repository.save(map(dto)));
    }

    public FoodDishDTO get(Integer id) {
        return repository.findById(id).map(this::map)
                .orElseThrow(() -> new IllegalArgumentException("Dish not found: " + id));
    }

    public List<FoodDishDTO> byRestaurant(UUID restaurantId) {
        return repository.findByRestaurantId(restaurantId).stream().map(this::map).toList();
    }

    public List<FoodDishDTO> list() {
        return repository.findAll().stream().map(this::map).toList();
    }

    public FoodDishDTO update(Integer id, FoodDishDTO dto) {
        FoodDish existing = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Dish not found: " + id));
        FoodDish toSave = map(dto);
        toSave.setId(id);
        return map(repository.save(toSave));
    }

    public void delete(Integer id) { repository.deleteById(id); }

    private FoodDish map(FoodDishDTO dto) {
        return new FoodDish(dto.id(), dto.restaurantId(), dto.name(), dto.description(), dto.price());
    }
    private FoodDishDTO map(FoodDish model) {
        return new FoodDishDTO(model.getId(), model.getRestaurantId(), model.getName(),
                model.getDescription(), model.getPrice());
    }
}
