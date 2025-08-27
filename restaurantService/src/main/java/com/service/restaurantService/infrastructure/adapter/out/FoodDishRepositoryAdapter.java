package com.service.restaurantService.infrastructure.adapter.out;

import com.service.restaurantService.domain.model.FoodDish;
import com.service.restaurantService.domain.port.out.FoodDishRepositoryPort;
import com.service.restaurantService.infrastructure.mapper.FoodDishMapper;
import com.service.restaurantService.infrastructure.persistence.repository.FoodDishJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FoodDishRepositoryAdapter implements FoodDishRepositoryPort {
    private final FoodDishJpaRepository jpa;

    public FoodDishRepositoryAdapter(FoodDishJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public FoodDish save(FoodDish dish) {
        return FoodDishMapper.toDomain(jpa.save(FoodDishMapper.toEntity(dish)));
    }

    @Override
    public Optional<FoodDish> findById(Integer id) {
        return jpa.findById(id).map(FoodDishMapper::toDomain);
    }

    @Override
    public List<FoodDish> findByRestaurantId(UUID restaurantId) {
        if (restaurantId == null) {
            return jpa.findAll().stream().map(FoodDishMapper::toDomain).toList();
        }
        return jpa.findByRestaurantId(restaurantId).stream().map(FoodDishMapper::toDomain).toList();
    }

    @Override
    public List<FoodDish> findAll() {
        return jpa.findAll().stream().map(FoodDishMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
