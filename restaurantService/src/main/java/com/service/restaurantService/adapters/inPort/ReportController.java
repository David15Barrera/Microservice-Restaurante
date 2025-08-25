package com.service.restaurantService.adapters.inPort;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final OrderJpaRepository orderRepo;
    private final OrderDetailJpaRepository detailRepo;

    public ReportController(OrderJpaRepository orderRepo, OrderDetailJpaRepository detailRepo) {
        this.orderRepo = orderRepo;
        this.detailRepo = detailRepo;
    }

    @GetMapping("/ingresos/{restaurantId}")
    @PreAuthorize("hasAuthority('SCOPE_ingreso.read') or hasRole('ADMIN')")
    public Map<String, Object> ingresosPorRango(
            @PathVariable UUID restaurantId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to
    ) {
        LocalDateTime f = from != null ? LocalDateTime.parse(from) : LocalDateTime.now().minusDays(30);
        LocalDateTime t = to != null ? LocalDateTime.parse(to) : LocalDateTime.now();

        List<OrderEntity> orders = orderRepo.findByRestaurantId(restaurantId).stream()
                .filter(o -> o.getDate() == null || (!o.getDate().isBefore(f) && !o.getDate().isAfter(t)))
                .collect(Collectors.toList());

        BigDecimal total = orders.stream()
                .map(o -> o.getTotalPrice() != null ? o.getTotalPrice() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Map.of(
                "restaurantId", restaurantId,
                "from", f.toString(),
                "to", t.toString(),
                "ingresos", total,
                "pedidos", orders.size()
        );
    }

    @GetMapping("/costos/{restaurantId}")
    @PreAuthorize("hasAuthority('SCOPE_costo.read') or hasRole('ADMIN')")
    public Map<String, Object> costosPorRango(
            @PathVariable UUID restaurantId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to
    ) {
        LocalDateTime f = from != null ? LocalDateTime.parse(from) : LocalDateTime.now().minusDays(30);
        LocalDateTime t = to != null ? LocalDateTime.parse(to) : LocalDateTime.now();

        // Filter order_ids for the restaurant and date range
        List<Integer> orderIds = orderRepo.findByRestaurantId(restaurantId).stream()
                .filter(o -> o.getDate() == null || (!o.getDate().isBefore(f) && !o.getDate().isAfter(t)))
                .map(OrderEntity::getId).collect(Collectors.toList());

        List<OrderDetailEntity> details = detailRepo.findAll().stream()
                .filter(d -> orderIds.contains(d.getOrderId()))
                .collect(Collectors.toList());

        BigDecimal totalCost = details.stream()
                .map(d -> d.getUnitCost().multiply(new BigDecimal(d.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Map.of(
                "restaurantId", restaurantId,
                "from", f.toString(),
                "to", t.toString(),
                "costos", totalCost,
                "lineas", details.size()
        );
    }
}
