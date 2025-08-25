package com.service.restaurantService.adapters.inPort;

import com.service.restaurantService.adapters.inPort.dto.DishRequest;
import com.service.restaurantService.adapters.inPort.dto.DishResponse;
import com.service.restaurantService.adapters.inPort.mapper.WebMapper;
import com.service.restaurantService.domain.model.dish;
import com.service.restaurantService.domain.useCase.DishService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_dish.write') or hasRole('ADMIN')")
    public ResponseEntity<DishResponse> create(@Valid @RequestBody DishRequest req) {
        dish created = service.crear(WebMapper.toDomain(req));
        DishResponse resp = WebMapper.toResponse(created);
        return ResponseEntity.created(URI.create("/api/dishes/" + resp.id)).body(resp);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_dish.read') or hasRole('ADMIN')")
    public ResponseEntity<DishResponse> get(@PathVariable Integer id) {
        return service.obtener(id)
                .map(d -> ResponseEntity.ok(WebMapper.toResponse(d)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_dish.read') or hasRole('ADMIN')")
    public List<DishResponse> list() {
        return service.listar().stream().map(WebMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    @PreAuthorize("hasAuthority('SCOPE_dish.read') or hasRole('ADMIN')")
    public List<DishResponse> listByRestaurant(@PathVariable UUID restaurantId) {
        return service.listarPorRestaurant(restaurantId).stream().map(WebMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_dish.write') or hasRole('ADMIN')")
    public ResponseEntity<DishResponse> update(@PathVariable Integer id, @Valid @RequestBody DishRequest req) {
        return service.obtener(id).map(existing -> {
            existing.setRestaurantId(req.restaurantId);
            existing.setName(req.name);
            existing.setDescription(req.description);
            existing.setPrice(req.price);
            dish updated = service.actualizar(existing);
            return ResponseEntity.ok(WebMapper.toResponse(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_dish.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
