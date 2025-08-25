package com.service.restaurantService.adapters.inPort;

import com.service.restaurantService.adapters.inPort.dto.OrderDetailRequest;
import com.service.restaurantService.adapters.inPort.dto.OrderDetailResponse;
import com.service.restaurantService.adapters.inPort.dto.OrderRequest;
import com.service.restaurantService.adapters.inPort.dto.OrderResponse;
import com.service.restaurantService.adapters.inPort.mapper.WebMapper;
import com.service.restaurantService.domain.model.order;
import com.service.restaurantService.domain.model.orderDetail;
import com.service.restaurantService.domain.useCase.OrderDetailService;
import com.service.restaurantService.domain.useCase.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService detailService;

    public OrderController(OrderService orderService, OrderDetailService detailService) {
        this.orderService = orderService;
        this.detailService = detailService;
    }

    // Orders
    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody OrderRequest req) {
        order created = orderService.crear(WebMapper.toDomain(req));
        OrderResponse resp = WebMapper.toResponse(created);
        return ResponseEntity.created(URI.create("/api/orders/" + resp.id)).body(resp);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public ResponseEntity<OrderResponse> get(@PathVariable Integer id) {
        return orderService.obtener(id)
                .map(o -> ResponseEntity.ok(WebMapper.toResponse(o)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public List<OrderResponse> list() {
        return orderService.listar().stream().map(WebMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public List<OrderResponse> listByRestaurant(@PathVariable UUID restaurantId) {
        return orderService.listarPorRestaurant(restaurantId).stream().map(WebMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderResponse> update(@PathVariable Integer id, @Valid @RequestBody OrderRequest req) {
        return orderService.obtener(id).map(existing -> {
            existing.setCustomerId(req.customerId);
            existing.setRestaurantId(req.restaurantId);
            existing.setDate(req.date);
            existing.setTotalPrice(req.totalPrice);
            existing.setDiscountPercentage(req.discountPercentage);
            existing.setPromotionId(req.promotionId);
            order updated = orderService.actualizar(existing);
            return ResponseEntity.ok(WebMapper.toResponse(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orderService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Order Details
    @PostMapping("/{orderId}/details")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderDetailResponse> addDetail(@PathVariable Integer orderId, @Valid @RequestBody OrderDetailRequest req) {
        req.orderId = orderId;
        orderDetail created = detailService.crear(WebMapper.toDomain(req));
        OrderDetailResponse resp = WebMapper.toResponse(created);
        return ResponseEntity.created(URI.create("/api/orders/" + orderId + "/details/" + resp.id)).body(resp);
    }

    @GetMapping("/{orderId}/details")
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public List<OrderDetailResponse> listDetails(@PathVariable Integer orderId) {
        return detailService.listarPorOrder(orderId).stream().map(WebMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/details/{detailId}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderDetailResponse> updateDetail(@PathVariable Integer detailId, @Valid @RequestBody OrderDetailRequest req) {
        return detailService.obtener(detailId).map(existing -> {
            existing.setOrderId(req.orderId != null ? req.orderId : existing.getOrderId());
            existing.setDishId(req.dishId);
            existing.setQuantity(req.quantity);
            existing.setUnitPrice(req.unitPrice);
            existing.setUnitCost(req.unitCost);
            existing.setSubtotal(req.subtotal);
            existing.setDiscountPercentage(req.discountPercentage);
            existing.setPromotionId(req.promotionId);
            orderDetail updated = detailService.actualizar(existing);
            return ResponseEntity.ok(WebMapper.toResponse(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/details/{detailId}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDetail(@PathVariable Integer detailId) {
        detailService.eliminar(detailId);
        return ResponseEntity.noContent().build();
    }
}
