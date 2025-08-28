package com.service.restaurantService.restaurant.adapters.in.web;

import com.service.restaurantService.restaurant.adapters.in.web.dto.RestaurantRequest;
import com.service.restaurantService.restaurant.adapters.in.web.dto.RestaurantResponse;
import com.service.restaurantService.restaurant.application.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service){
        this.service=service;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_restaurant.write') or hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponse> create(@Valid @RequestBody RestaurantRequest req){
        var r=RestaurantMapper.toDomain(req);
        r.setId(UUID.randomUUID());
        var created=service.create(r);
        return ResponseEntity.created(URI.create("/api/restaurants/"+created.getId())).body(RestaurantMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_restaurant.read') or hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponse> get(@PathVariable UUID id){
        return service.get(id).map(RestaurantMapper::toResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_restaurant.read') or hasRole('ADMIN')")
    public List<RestaurantResponse> list(){
        return service.list().stream().map(RestaurantMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_restaurant.write') or hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponse> update(@PathVariable UUID id, @Valid @RequestBody RestaurantRequest req){
        var r=RestaurantMapper.toDomain(req);
        r.setId(id);
        var updated = service.update(r);
        return ResponseEntity.ok(RestaurantMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_restaurant.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
