package com.service.restaurantService.adapters.inPort;

import com.service.restaurantService.adapters.inPort.dto.RestaurantRequest;
import com.service.restaurantService.adapters.inPort.dto.RestaurantResponse;
import com.service.restaurantService.adapters.inPort.mapper.WebMapper;
import com.service.restaurantService.domain.model.restaurant;
import com.service.restaurantService.domain.useCase.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_restaurant.write') or hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponse> create(@Valid @RequestBody RestaurantRequest req) {
        restaurant created = service.crear(WebMapper.toDomain(req));
        RestaurantResponse resp = WebMapper.toResponse(created);
        return ResponseEntity.created(URI.create("/api/restaurants/" + resp.id)).body(resp);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_restaurant.read') or hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponse> get(@PathVariable UUID id) {
        return service.obtener(id)
                .map(r -> ResponseEntity.ok(WebMapper.toResponse(r)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_restaurant.read') or hasRole('ADMIN')")
    public List<RestaurantResponse> list() {
        return service.listar().stream().map(WebMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_restaurant.write') or hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponse> update(@PathVariable UUID id, @Valid @RequestBody RestaurantRequest req) {
        return service.obtener(id).map(existing -> {
            existing.setName(req.name);
            existing.setHotelId(req.hotelId);
            existing.setAddress(req.address);
            existing.setPhone(req.phone);
            existing.setCapacity(req.capacity);
            existing.setOpeningTime(req.openingTime);
            existing.setClosingTime(req.closingTime);
            restaurant updated = service.actualizar(existing);
            return ResponseEntity.ok(WebMapper.toResponse(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_restaurant.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
