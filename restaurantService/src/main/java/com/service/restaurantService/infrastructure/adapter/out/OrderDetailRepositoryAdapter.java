package com.service.restaurantService.infrastructure.adapter.out;

import com.service.restaurantService.domain.model.OrderDetail;
import com.service.restaurantService.domain.port.out.OrderDetailRepositoryPort;
import com.service.restaurantService.infrastructure.persistence.entity.OrderDetailEntity;
import com.service.restaurantService.infrastructure.persistence.entity.OrderEntity;
import com.service.restaurantService.infrastructure.persistence.repository.OrderDetailJpaRepository;
import com.service.restaurantService.infrastructure.persistence.repository.OrderJpaRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderDetailRepositoryAdapter implements OrderDetailRepositoryPort {
    private final OrderDetailJpaRepository jpa;
    private final OrderJpaRepository orderJpa;

    public OrderDetailRepositoryAdapter(OrderDetailJpaRepository jpa, OrderJpaRepository orderJpa) {
        this.jpa = jpa;
        this.orderJpa = orderJpa;
    }

    @Override
    public OrderDetail save(OrderDetail detail) {
        OrderDetailEntity e = toEntity(detail);
        OrderDetailEntity saved = jpa.save(e);
        return toDomain(saved);
    }

    @Override
    public java.util.Optional<OrderDetail> findById(Integer id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public java.util.List<OrderDetail> findByOrderId(Integer orderId) {
        return jpa.findByOrderId(orderId).stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    private OrderDetail toDomain(OrderDetailEntity e) {
        OrderDetail d = new OrderDetail();
        d.setId(e.getId());
        d.setOrderId(e.getOrder() != null ? e.getOrder().getId() : null);
        d.setDishId(e.getDishId());
        d.setQuantity(e.getQuantity());
        d.setUnitPrice(e.getUnitPrice());
        d.setUnitCost(e.getUnitCost());
        d.setSubtotal(e.getSubtotal());
        d.setDiscountPercentage(e.getDiscountPercentage());
        return d;
    }

    private OrderDetailEntity toEntity(OrderDetail d) {
        OrderDetailEntity e = new OrderDetailEntity();
        e.setId(d.getId());
        if (d.getOrderId() != null) {
            OrderEntity order = orderJpa.findById(d.getOrderId()).orElseThrow(() -> new IllegalArgumentException("Order not found: " + d.getOrderId()));
            e.setOrder(order);
        }
        e.setDishId(d.getDishId());
        e.setQuantity(d.getQuantity());
        e.setUnitPrice(d.getUnitPrice());
        e.setUnitCost(d.getUnitCost());
        e.setSubtotal(d.getSubtotal());
        e.setDiscountPercentage(d.getDiscountPercentage());
        return e;
    }
}
