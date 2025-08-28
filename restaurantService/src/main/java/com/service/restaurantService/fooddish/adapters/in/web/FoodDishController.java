package com.service.restaurantService.fooddish.adapters.in.web;

import com.service.restaurantService.fooddish.adapters.in.web.dto.*;
import com.service.restaurantService.fooddish.application.FoodDishService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.stream.Collectors;
@RestController @RequestMapping("/api/dishes") public class FoodDishController {
    private final FoodDishService service;

    public FoodDishController(FoodDishService service){
        this.service=service;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_dish.write') or hasRole('ADMIN')")
    public ResponseEntity<FoodDishResponse> create(@Valid @RequestBody FoodDishRequest req) {
        var d = FoodDishMapper.toDomain(req);
        d.setId(null);

        var created = service.create(d);

        return ResponseEntity
                .created(URI.create("/api/dishes/" + created.getId()))
                .body(FoodDishMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_dish.read') or hasRole('ADMIN')")
    public ResponseEntity<FoodDishResponse> get(@PathVariable java.util.UUID id){
        return service.get(id).map(FoodDishMapper::toResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_dish.read') or hasRole('ADMIN')")
    public java.util.List<FoodDishResponse> list(){ return service.list().stream().map(FoodDishMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    @PreAuthorize("hasAuthority('SCOPE_dish.read') or hasRole('ADMIN')")

    public java.util.List<FoodDishResponse> byRestaurant(@PathVariable java.util.UUID restaurantId){
        return service.listByRestaurant(restaurantId).stream().map(FoodDishMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_dish.write') or hasRole('ADMIN')")
    public ResponseEntity<FoodDishResponse> update(@PathVariable Integer id, @Valid @RequestBody FoodDishRequest req){
        var d=FoodDishMapper.toDomain(req); d.setId(id);
        var updated = service.update(d);
        return ResponseEntity.ok(FoodDishMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_dish.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable java.util.UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
