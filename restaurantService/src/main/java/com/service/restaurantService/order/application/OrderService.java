package com.service.restaurantService.order.application;

import com.service.restaurantService.order.domain.model.Order;
import com.service.restaurantService.order.domain.port.OrderRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepositoryPort repo;

    public OrderService(OrderRepositoryPort repo) {
        this.repo = repo;
    }

    public Order create(Order o) {
        return repo.save(o);
    }

    public Optional<Order> get(Integer id) {
        return repo.findById(id);
    }

    public List<Order> list() {
        return repo.findAll();
    }

    public List<Order> listByRestaurant(UUID restaurantId) {
        return repo.findByRestaurantId(restaurantId);
    }

    public Order update(Order o) {
        return repo.save(o);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
