package com.service.restaurantService.adapters.outPort.persistance;

import com.service.restaurantService.adapters.outPort.persistance.entity.RestaurantEntity;
import com.service.restaurantService.adapters.outPort.persistance.mapper.PersistenceMapper;
import com.service.restaurantService.adapters.outPort.persistance.repository.RestaurantJpaRepository;
import com.service.restaurantService.domain.model.restaurant;
import com.service.restaurantService.domain.ports.RestaurantRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantRepositoryAdapter implements RestaurantRepositoryPort {

    private final RestaurantJpaRepository jpa;

    public RestaurantRepositoryAdapter(RestaurantJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public restaurant save(restaurant restaurant) {
        RestaurantEntity saved = jpa.save(PersistenceMapper.toEntity(restaurant));
        return PersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<restaurant> findById(UUID id) {
        return jpa.findById(id).map(PersistenceMapper::toDomain);
    }

    @Override
    public List<restaurant> findAll() {
        return jpa.findAll().stream().map(PersistenceMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }
}
