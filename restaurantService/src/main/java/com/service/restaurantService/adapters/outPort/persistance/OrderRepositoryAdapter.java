package com.service.restaurantService.adapters.outPort.persistance;

import com.service.restaurantService.adapters.outPort.persistance.entity.OrderEntity;
import com.service.restaurantService.adapters.outPort.persistance.mapper.PersistenceMapper;
import com.service.restaurantService.adapters.outPort.persistance.repository.OrderJpaRepository;
import com.service.restaurantService.domain.model.order;
import com.service.restaurantService.domain.ports.OrderRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {

    private final OrderJpaRepository jpa;

    public OrderRepositoryAdapter(OrderJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public order save(order order) {
        OrderEntity saved = jpa.save(PersistenceMapper.toEntity(order));
        return PersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<order> findById(Integer id) {
        return jpa.findById(id).map(PersistenceMapper::toDomain);
    }

    @Override
    public List<order> findAll() {
        return jpa.findAll().stream().map(PersistenceMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<order> findByRestaurantId(UUID restaurantId) {
        return jpa.findByRestaurantId(restaurantId).stream().map(PersistenceMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
