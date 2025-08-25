package com.service.restaurantService.domain.useCase;

import com.service.restaurantService.domain.model.dish;
import com.service.restaurantService.domain.ports.DishRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DishService {
    private final DishRepositoryPort repository;

    public DishService(DishRepositoryPort repository) {
        this.repository = repository;
    }

    public dish crear(dish d) {
        return repository.save(d);
    }
    public Optional<dish> obtener(Integer id) {
        return repository.findById(id);
    }

    public List<dish> listar() {
        return repository.findAll();
    }

    public List<dish> listarPorRestaurant(UUID restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }

    public dish actualizar(dish d) {
        return repository.save(d);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
