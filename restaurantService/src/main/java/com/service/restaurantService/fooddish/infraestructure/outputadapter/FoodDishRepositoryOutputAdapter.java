package com.service.restaurantService.fooddish.infraestructure.outputadapter;

import com.service.restaurantService.fooddish.application.ports.output.DeleteFoodDishOutputPort;
import com.service.restaurantService.fooddish.application.ports.output.FindFoodDishesByRestaurantOutputPort;
import com.service.restaurantService.fooddish.application.ports.output.SaveFoodDishOutputPort;
import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.entity.FoodDishDBEntity;
import com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.mapper.FoodDishMapper;
import com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.repository.FoodDishDBRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FoodDishRepositoryOutputAdapter implements
        SaveFoodDishOutputPort,
        DeleteFoodDishOutputPort,
        FindFoodDishesByRestaurantOutputPort {

    private final FoodDishDBRepository repo;

    public FoodDishRepositoryOutputAdapter(FoodDishDBRepository repo) {
        this.repo = repo;
    }

    @Override
    public FoodDishDomainEntity save(FoodDishDomainEntity dish) {
        FoodDishDBEntity e = FoodDishMapper.toEntity(dish);
       FoodDishDBEntity saved = repo.save(e);
       return FoodDishMapper.toDomain(saved);
   }

 @Override
 public void deleteById(Integer id) {
     repo.deleteById(id);
  }

    @Override
    public Optional<FoodDishDomainEntity> findById(Integer id) {
        return repo.findById(id).map(FoodDishMapper::toDomain);
    }

    @Override
    public List<FoodDishDomainEntity> findAll() {
        return repo.findAll().stream().map(FoodDishMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<FoodDishDomainEntity> findByRestaurantId(UUID restaurantId) {
        return repo.findByRestaurantId(restaurantId)
                .stream()
                .map(FoodDishMapper::toDomain)
                .collect(Collectors.toList());
    }
}
