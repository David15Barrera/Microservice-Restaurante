package com.service.restaurantService.adapters.outPort.persistance;

import com.service.restaurantService.adapters.outPort.persistance.entity.DishEntity;
import com.service.restaurantService.adapters.outPort.persistance.mapper.PersistenceMapper;
import com.service.restaurantService.adapters.outPort.persistance.repository.DishJpaRepository;
import com.service.restaurantService.domain.model.dish;
import com.service.restaurantService.domain.ports.DishRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DishRepositoryAdapter implements DishRepositoryPort {

    private final DishJpaRepository jpa;

    public DishRepositoryAdapter(DishJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public dish save(dish dishes) {
        DishEntity saved = jpa.save(PersistenceMapper.toEntity(dishes));
        return PersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<dish> findById(Integer id) {
        return jpa.findById(id).map(PersistenceMapper::toDomain);
    }

    @Override
    public List<dish> findByRestaurantId(UUID restaurantId) {
        return jpa.findByRestaurantId(restaurantId).stream().map(PersistenceMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<dish> findAll() {
        return jpa.findAll().stream().map(PersistenceMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
