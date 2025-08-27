package com.service.restaurantService.infrastructure.adapter.in.rest;

import com.service.restaurantService.application.dto.OrderDTO;
import com.service.restaurantService.application.dto.OrderDetailDTO;
import com.service.restaurantService.application.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@Valid @RequestBody OrderDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Integer id, @Valid @RequestBody OrderDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    public ResponseEntity<List<OrderDTO>> byRestaurantPath(@PathVariable UUID restaurantId) {
        return ResponseEntity.ok(service.byRestaurantAll(restaurantId));
    }

    @GetMapping("/by-restaurant")
    public ResponseEntity<List<OrderDTO>> byRestaurant(
            @RequestParam UUID restaurantId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        return ResponseEntity.ok(service.byRestaurantBetween(restaurantId, from, to));
    }

    @GetMapping("/by-customer")
    public ResponseEntity<List<OrderDTO>> byCustomer(
            @RequestParam UUID customerId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        return ResponseEntity.ok(service.byCustomerBetween(customerId, from, to));
    }

    @GetMapping("/{orderId}/details")
    public ResponseEntity<List<OrderDetailDTO>> details(@PathVariable Integer orderId) {
        return ResponseEntity.ok(service.getDetailsByOrder(orderId));
    }

    @PostMapping("/{orderId}/details")
    public ResponseEntity<OrderDetailDTO> addDetail(@PathVariable Integer orderId, @Valid @RequestBody OrderDetailDTO dto) {
        return ResponseEntity.ok(service.addDetailToOrder(orderId, dto));
    }

    @PutMapping("/details/{detailId}")
    public ResponseEntity<OrderDetailDTO> updateDetail(@PathVariable Integer detailId, @Valid @RequestBody OrderDetailDTO dto) {
        return ResponseEntity.ok(service.updateDetail(detailId, dto));
    }

    @DeleteMapping("/details/{detailId}")
    public ResponseEntity<Void> deleteDetail(@PathVariable Integer detailId) {
        service.deleteDetail(detailId);
        return ResponseEntity.noContent().build();
    }
}
