package com.service.restaurantService.fooddish.infraestructure.inputadapter.rest;

import com.service.restaurantService.fooddish.application.ports.input.*;
import com.service.restaurantService.fooddish.domain.model.FoodDishDomainEntity;
import com.service.restaurantService.fooddish.infraestructure.inputadapter.dto.FoodDishRequestDto;
import com.service.restaurantService.fooddish.infraestructure.inputadapter.dto.FoodDishResponseDto;
import com.service.restaurantService.fooddish.infraestructure.inputadapter.mapper.FoodDishMapperRest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dishes")
public class FoodDishControllerAdapter {
    private final ListAllFoodDishInputPort listAllUseCase;
    private final CreateFoodDishInputPort createUseCase;
    private final UpdateFoodDishInputPort updateUseCase;
    private final GetFoodDishByIdInputPort getUseCase;
    private final DeleteFoodDishInputPort deleteUseCase;
    private final FindFoodDishesByRestaurantInputPort findByRestauranUseCase;

    public FoodDishControllerAdapter(ListAllFoodDishInputPort listAllUseCase,
                                     CreateFoodDishInputPort createUseCase,
                                     UpdateFoodDishInputPort updateUseCase,
                                     GetFoodDishByIdInputPort getUseCase,
                                     DeleteFoodDishInputPort deleteUseCase,
                                     FindFoodDishesByRestaurantInputPort findByRestauranUseCase) {
        this.listAllUseCase = listAllUseCase;
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.getUseCase = getUseCase;
        this.deleteUseCase = deleteUseCase;
        this.findByRestauranUseCase = findByRestauranUseCase;
    }

    @GetMapping
    public ResponseEntity<List<FoodDishResponseDto>> listAll() {
        List<FoodDishDomainEntity> all = listAllUseCase.listAll();
        List<FoodDishResponseDto> resp = all.stream().map(FoodDishMapperRest::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDishResponseDto> getById(@PathVariable UUID id) {
        FoodDishDomainEntity d = getUseCase.getById(id);
        return ResponseEntity.ok(FoodDishMapperRest.toResponse(d));
    }

    @PostMapping
    public ResponseEntity<FoodDishResponseDto> create(@RequestBody FoodDishRequestDto dto) {
        FoodDishDomainEntity domain = FoodDishMapperRest.toDomain(dto);
        FoodDishDomainEntity created = createUseCase.create(domain);
        return ResponseEntity.status(201).body(FoodDishMapperRest.toResponse(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodDishResponseDto> update(@PathVariable UUID id, @RequestBody FoodDishRequestDto dto) {
        FoodDishDomainEntity domain = FoodDishMapperRest.toDomain(dto);
        domain.setId(id);
        FoodDishDomainEntity updated = updateUseCase.update(domain);
        return ResponseEntity.ok(FoodDishMapperRest.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    public ResponseEntity<List<FoodDishResponseDto>> getByRestaurantId(@PathVariable UUID restaurantId) {
        List<FoodDishDomainEntity> dishes = findByRestauranUseCase.findByRestaurantId(restaurantId);
        List<FoodDishResponseDto> response = dishes.stream()
                .map(FoodDishMapperRest::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
