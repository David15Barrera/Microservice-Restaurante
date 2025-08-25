package com.service.restaurantService.domain.useCase;


import com.service.restaurantService.domain.model.orderDetail;
import com.service.restaurantService.domain.ports.OrderDetailRepositoryPort;

import java.util.List;
import java.util.Optional;

public class OrderDetailService {
    private final OrderDetailRepositoryPort repository;

    public OrderDetailService(OrderDetailRepositoryPort repository) {
        this.repository = repository;
    }

    public orderDetail crear(orderDetail d) {
        return repository.save(d);
    }

    public Optional<orderDetail> obtener(Integer id) {
        return repository.findById(id);
    }

    public List<orderDetail> listar() {
        return repository.findAll();
    }

    public List<orderDetail> listarPorOrder(Integer orderId) {
        return repository.findByOrderId(orderId);
    }

    public orderDetail actualizar(orderDetail d) {
        return repository.save(d);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
