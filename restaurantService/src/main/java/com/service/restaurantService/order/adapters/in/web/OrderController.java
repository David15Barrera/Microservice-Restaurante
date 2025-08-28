package com.service.restaurantService.order.adapters.in.web;

import com.service.restaurantService.order.adapters.in.web.OrderMapper;
import com.service.restaurantService.order.adapters.in.web.dto.OrderRequest;
import com.service.restaurantService.order.adapters.in.web.dto.OrderResponse;
import com.service.restaurantService.order.application.OrderService;
import com.service.restaurantService.order.domain.model.Order;
import com.service.restaurantService.orderdetail.adapters.in.web.OrderDetailMapper;
import com.service.restaurantService.orderdetail.adapters.in.web.dto.OrderDetailRequest;
import com.service.restaurantService.orderdetail.adapters.in.web.dto.OrderDetailResponse;
import com.service.restaurantService.orderdetail.application.OrderDetailService;
import com.service.restaurantService.orderdetail.domain.model.OrderDetail;
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
    public OrderController(OrderService orderService, OrderDetailService detailService){ this.orderService = orderService; this.detailService = detailService; }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody OrderRequest req){
        Order o = OrderMapper.toDomain(req); Order created = orderService.create(o);
        return ResponseEntity.created(URI.create("/api/orders/" + created.getId())).body(OrderMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public ResponseEntity<OrderResponse> get(@PathVariable Integer id) {
        return orderService.get(id).map(OrderMapper::toResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public List<OrderResponse> list(){
        return orderService.list().stream().map(OrderMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public List<OrderResponse> byRestaurant(@PathVariable UUID restaurantId){
        return orderService.listByRestaurant(restaurantId).stream().map(OrderMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderResponse> update(@PathVariable Integer id, @Valid @RequestBody OrderRequest req){
        Order o = OrderMapper.toDomain(req);
        o.setId(id); Order updated = orderService.update(o);
        return ResponseEntity.ok(OrderMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // order detail nested endpoints for convenience
    @PostMapping("/{orderId}/details")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderDetailResponse> addDetail(@PathVariable Integer orderId, @Valid @RequestBody OrderDetailRequest req){
        req.orderId = orderId;
        OrderDetail d = OrderDetailMapper.toDomain(req);
        OrderDetail created = detailService.create(d);
        return ResponseEntity.created(URI.create("/api/orders/" + orderId + "/details/" + created.getId())).body(OrderDetailMapper.toResponse(created));
    }

    @GetMapping("/{orderId}/details")
    @PreAuthorize("hasAuthority('SCOPE_consumo.read') or hasRole('ADMIN')")
    public List<OrderDetailResponse> listDetails(@PathVariable Integer orderId){
        return detailService.listByOrder(orderId).stream().map(OrderDetailMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/details/{detailId}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<OrderDetailResponse> updateDetail(@PathVariable Integer detailId, @Valid @RequestBody OrderDetailRequest req){ OrderDetail d = OrderDetailMapper.toDomain(req); d.setId(detailId); OrderDetail updated = detailService.update(d);
        return ResponseEntity.ok(OrderDetailMapper.toResponse(updated));
    }

    @DeleteMapping("/details/{detailId}")
    @PreAuthorize("hasAuthority('SCOPE_consumo.write') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDetail(@PathVariable Integer detailId){
        detailService.delete(detailId);
        return ResponseEntity.noContent().build();
    }
}
