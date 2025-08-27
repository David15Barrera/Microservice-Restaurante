package com.service.restaurantService.infrastructure.adapter.out;

import com.service.restaurantService.domain.model.Order;
import com.service.restaurantService.domain.port.out.OrderRepositoryPort;
import com.service.restaurantService.infrastructure.mapper.OrderMapper;
import com.service.restaurantService.infrastructure.persistence.repository.OrderJpaRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {
    private final OrderJpaRepository jpa;

    public OrderRepositoryAdapter(OrderJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Order save(Order order) {
        return OrderMapper.toDomain(jpa.save(OrderMapper.toEntity(order)));
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return jpa.findById(id).map(OrderMapper::toDomain);
    }

    @Override
    public List<Order> findByRestaurantAndDateRange(UUID restaurantId, Instant from, Instant to) {
        return jpa.findByRestaurantAndDateRange(restaurantId, from, to).stream().map(OrderMapper::toDomain).toList();
    }

    @Override
    public List<Order> findByCustomerAndDateRange(UUID customerId, Instant from, Instant to) {
        return jpa.findByCustomerAndDateRange(customerId, from, to).stream().map(OrderMapper::toDomain).toList();
    }

    @Override
    public List<Order> findAll() {
        return jpa.findAll().stream().map(OrderMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
