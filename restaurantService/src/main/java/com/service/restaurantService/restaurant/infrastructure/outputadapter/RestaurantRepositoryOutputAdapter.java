package com.service.restaurantService.restaurant.infrastructure.outputadapter;

import com.service.restaurantService.restaurant.application.ports.output.SaveRestaurantOutputPort;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.persistence.entity.RestaurantDBEntity;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.persistence.mapper.RestaurantMapper;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.persistence.repository.RestaurantDBRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantRepositoryOutputAdapter implements SaveRestaurantOutputPort {

    private final RestaurantDBRepository repo;

    public RestaurantRepositoryOutputAdapter(RestaurantDBRepository repo) {
        this.repo = repo;
    }

    @Override
    public RestaurantDomainEntity save(RestaurantDomainEntity restaurant) {
        if (restaurant.getId() == null) {
            restaurant.setId(UUID.randomUUID());
        }
        RestaurantDBEntity entity = RestaurantMapper.toEntity(restaurant);
        RestaurantDBEntity saved = repo.save(entity);
        return RestaurantMapper.toDomain(saved);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<RestaurantDomainEntity> findById(UUID id) {
        return repo.findById(id).map(RestaurantMapper::toDomain);
    }

    @Override
    public List<RestaurantDomainEntity> findAll() {
        return repo.findAll().stream().map(RestaurantMapper::toDomain).collect(Collectors.toList());
    }
}
