package com.service.restaurantService.domain.useCase;


import com.service.restaurantService.domain.model.order;
import com.service.restaurantService.domain.ports.OrderRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderService {
    private final OrderRepositoryPort repository;

    public OrderService(OrderRepositoryPort repository) {
        this.repository = repository;

    }

    public order crear(order o) {
        return repository.save(o);
    }
    public Optional<order> obtener(Integer id) {
        return repository.findById(id);
    }

    public List<order> listar() {
        return repository.findAll();
    }

    public List<order> listarPorRestaurant(UUID restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }

    public order actualizar(order o) {
        return repository.save(o);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
