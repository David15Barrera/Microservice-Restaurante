package com.service.restaurantService.restaurant.infrastructure.inputadapter.rest;

import com.service.restaurantService.restaurant.application.ports.input.*;
import com.service.restaurantService.restaurant.application.ports.output.FindHotelOutputPort;
import com.service.restaurantService.restaurant.domain.model.RestaurantDomainEntity;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.RestaurantRequestDto;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.dto.RestaurantResponseDto;
import com.service.restaurantService.restaurant.infrastructure.inputadapter.mapper.RestaurantMapperRest;
import com.service.restaurantService.restaurant.infrastructure.outputadapter.factory.RestaurantWithHotelFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantControllerAdapter {

    private final CreateRestaurantInputPort createUseCase;
    private final UpdateRestaurantInputPort updateUseCase;
    private final GetRestaurantByIdInputPort getByIdUseCase;
    private final ListAllRestaurantInputPort listAllUseCase;
    private final DeleteRestaurantInputPort deleteUseCase;
    private final RestaurantWithHotelFactory restaurantFactory;

    public RestaurantControllerAdapter(CreateRestaurantInputPort createUseCase,
                                       UpdateRestaurantInputPort updateUseCase,
                                       GetRestaurantByIdInputPort getByIdUseCase,
                                       ListAllRestaurantInputPort listAllUseCase,
                                       DeleteRestaurantInputPort deleteUseCase,
                                       RestaurantWithHotelFactory restaurantFactory) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listAllUseCase = listAllUseCase;
        this.deleteUseCase = deleteUseCase;
        this.restaurantFactory = restaurantFactory;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> getById(@PathVariable UUID id) {
        RestaurantDomainEntity d = getByIdUseCase.getById(id);
        return ResponseEntity.ok(restaurantFactory.fromDomain(d));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> listAll() {
        List<RestaurantDomainEntity> all = listAllUseCase.listAll();
        return ResponseEntity.ok(restaurantFactory.fromDomainList(all));
    }

    @PostMapping
    public ResponseEntity<RestaurantResponseDto> create(@RequestBody RestaurantRequestDto dto) {
        RestaurantDomainEntity created = createUseCase.create(RestaurantMapperRest.toDomain(dto));
        return ResponseEntity.ok(restaurantFactory.fromDomain(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> update(@PathVariable UUID id, @RequestBody RestaurantRequestDto dto) {
        RestaurantDomainEntity domain = RestaurantMapperRest.toDomain(dto);
        domain.setId(id);
        RestaurantDomainEntity updated = updateUseCase.update(domain);
        return ResponseEntity.ok(restaurantFactory.fromDomain(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
