package com.service.restaurantService.infrastructure.adapter.out;

import com.service.restaurantService.domain.model.Restaurant;
import com.service.restaurantService.domain.port.out.RestaurantRepositoryPort;
import com.service.restaurantService.infrastructure.mapper.RestaurantMapper;
import com.service.restaurantService.infrastructure.persistence.entity.RestaurantEntity;
import com.service.restaurantService.infrastructure.persistence.repository.RestaurantJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RestaurantRepositoryAdapter implements RestaurantRepositoryPort {
    private final RestaurantJpaRepository jpa;

    public RestaurantRepositoryAdapter(RestaurantJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        RestaurantEntity saved = jpa.save(RestaurantMapper.toEntity(restaurant));
        return RestaurantMapper.toDomain(saved);
    }

    @Override
    public Optional<Restaurant> findById(UUID id) {
        return jpa.findById(id).map(RestaurantMapper::toDomain);
    }

    @Override
    public List<Restaurant> findAll() {
        return jpa.findAll().stream().map(RestaurantMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }
}
