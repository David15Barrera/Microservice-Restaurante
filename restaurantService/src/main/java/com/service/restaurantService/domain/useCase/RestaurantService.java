package com.service.restaurantService.domain.useCase;

import com.service.restaurantService.domain.model.restaurant;
import com.service.restaurantService.domain.ports.RestaurantRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RestaurantService {
    private final RestaurantRepositoryPort repository;

    public RestaurantService(RestaurantRepositoryPort repository) {
        this.repository = repository;
    }

    public restaurant crear(restaurant r) {
        return repository.save(r);
    }

    public Optional<restaurant> obtener(UUID id) {
        return repository.findById(id);
    }

    public List<restaurant> listar() {
        return repository.findAll();
    }

    public restaurant actualizar(restaurant r) {
        return repository.save(r);
    }

    public void eliminar(UUID id) {
        repository.deleteById(id);
    }
}
