package com.service.restaurantService.infrastructure.adapter.in.rest;

import com.service.restaurantService.application.dto.FoodDishDTO;
import com.service.restaurantService.application.service.FoodDishService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/dishes")
public class FoodDishController {
    private final FoodDishService service;

    public FoodDishController(FoodDishService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<FoodDishDTO> create(@Valid @RequestBody FoodDishDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDishDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<List<FoodDishDTO>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    public ResponseEntity<List<FoodDishDTO>> byRestaurant(@PathVariable UUID restaurantId) {
        return ResponseEntity.ok(service.byRestaurant(restaurantId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodDishDTO> update(@PathVariable Integer id, @Valid @RequestBody FoodDishDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
