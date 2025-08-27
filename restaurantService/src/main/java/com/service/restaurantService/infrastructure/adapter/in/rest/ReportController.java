package com.service.restaurantService.infrastructure.adapter.in.rest;

import com.service.restaurantService.application.dto.OrderDTO;
import com.service.restaurantService.application.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/reports")
public class ReportController {
    private final OrderService orderService;

    public ReportController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/ingresos/{restaurantId}")
    public ResponseEntity<Map<String, Object>> ingresos(@PathVariable UUID restaurantId) {
        List<OrderDTO> orders = orderService.byRestaurantAll(restaurantId);
        BigDecimal total = orders.stream().map(OrderDTO::totalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.ok(Map.of("restaurantId", restaurantId, "from", null, "to", Instant.now(), "ingresos", total));
    }

    @GetMapping("/costos/{restaurantId}")
    public ResponseEntity<Map<String, Object>> costos(@PathVariable UUID restaurantId) {
        List<OrderDTO> orders = orderService.byRestaurantAll(restaurantId);
        BigDecimal totalCost = orders.stream().flatMap(o -> o.details().stream())
                .map(d -> d.unitCost().multiply(BigDecimal.valueOf(d.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.ok(Map.of("restaurantId", restaurantId, "costos", totalCost));
    }

    @GetMapping("/income")
    public ResponseEntity<Map<String, Object>> income(
            @RequestParam UUID restaurantId,
            @RequestParam @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        List<OrderDTO> orders = orderService.byRestaurantBetween(restaurantId, from, to);
        BigDecimal total = orders.stream().map(OrderDTO::totalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.ok(Map.of("restaurantId", restaurantId, "from", from, "to", to, "income", total));
    }

    @GetMapping("/customer-consumption")
    public ResponseEntity<Map<String, Object>> customerConsumption(
            @RequestParam UUID customerId,
            @RequestParam @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        List<OrderDTO> orders = orderService.byCustomerBetween(customerId, from, to);
        BigDecimal total = orders.stream().map(OrderDTO::totalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        return ResponseEntity.ok(Map.of("customerId", customerId, "from", from, "to", to, "totalSpent", total));
    }
}
