package com.service.restaurantService.application.service;

import com.service.restaurantService.application.dto.OrderDTO;
import com.service.restaurantService.application.dto.OrderDetailDTO;
import com.service.restaurantService.domain.model.Order;
import com.service.restaurantService.domain.model.OrderDetail;
import com.service.restaurantService.domain.port.out.OrderDetailRepositoryPort;
import com.service.restaurantService.domain.port.out.OrderRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepositoryPort repository;
    private final OrderDetailRepositoryPort detailRepository;

    public OrderService(OrderRepositoryPort repository, OrderDetailRepositoryPort detailRepository) {
        this.repository = repository;
        this.detailRepository = detailRepository;
    }

    public OrderDTO create(OrderDTO dto) {
        Order order = map(dto);
        // compute totals
        BigDecimal total = order.getDetails().stream()
                .map(d -> d.getUnitPrice().multiply(BigDecimal.valueOf(d.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (order.getDiscountPercentage() != null) {
            BigDecimal discount = total.multiply(order.getDiscountPercentage()).divide(BigDecimal.valueOf(100));
            total = total.subtract(discount);
        }
        order.setTotalPrice(total);
        order.setDate(order.getDate() == null ? Instant.now() : order.getDate());
        Order saved = repository.save(order);
        return map(saved);
    }

    public OrderDTO get(Integer id) {
        return repository.findById(id).map(this::map)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));
    }

    public OrderDTO update(Integer id, OrderDTO dto) {
        Order existing = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));
        existing.setCustomerId(dto.customerId());
        existing.setRestaurantId(dto.restaurantId());
        existing.setDiscountPercentage(dto.discountPercentage());
        existing.setPromotionId(dto.promotionId());
        existing.setDate(dto.date() == null ? existing.getDate() : dto.date());
        if (dto.details() != null) {
            existing.setDetails(dto.details().stream().map(this::map).toList());
        }
        // recompute total
        BigDecimal total = existing.getDetails().stream()
                .map(d -> d.getUnitPrice().multiply(BigDecimal.valueOf(d.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (existing.getDiscountPercentage() != null) {
            BigDecimal discount = total.multiply(existing.getDiscountPercentage()).divide(BigDecimal.valueOf(100));
            total = total.subtract(discount);
        }
        existing.setTotalPrice(total);
        Order saved = repository.save(existing);
        return map(saved);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<OrderDTO> listAll() {
        return repository.findAll().stream().map(this::map).toList();
    }

    public List<OrderDTO> byRestaurantBetween(UUID restaurantId, Instant from, Instant to) {
        return repository.findByRestaurantAndDateRange(restaurantId, from, to).stream().map(this::map).toList();
    }

    public List<OrderDTO> byCustomerBetween(UUID customerId, Instant from, Instant to) {
        return repository.findByCustomerAndDateRange(customerId, from, to).stream().map(this::map).toList();
    }

    public List<OrderDTO> byRestaurantAll(UUID restaurantId) {
        // get all and filter by restaurantId
        return repository.findAll().stream().filter(o -> restaurantId.equals(o.getRestaurantId())).map(this::map).toList();
    }

    public List<OrderDetailDTO> getDetailsByOrder(Integer orderId) {
        return detailRepository.findByOrderId(orderId).stream().map(d -> new OrderDetailDTO(
                d.getId(), d.getOrderId(), d.getDishId(), d.getQuantity(), d.getUnitPrice(),
                d.getUnitCost(), d.getSubtotal(), d.getDiscountPercentage()
        )).toList();
    }

    public OrderDetailDTO addDetailToOrder(Integer orderId, OrderDetailDTO dto) {
        OrderDetail d = map(dto);
        d.setOrderId(orderId);
        OrderDetail saved = detailRepository.save(d);

        // update order totals
        Order order = repository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
        order.getDetails().add(saved);
        // recompute totals
        BigDecimal total = order.getDetails().stream()
                .map(det -> det.getUnitPrice().multiply(BigDecimal.valueOf(det.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (order.getDiscountPercentage() != null) {
            BigDecimal discount = total.multiply(order.getDiscountPercentage()).divide(BigDecimal.valueOf(100));
            total = total.subtract(discount);
        }
        order.setTotalPrice(total);
        repository.save(order);

        return new OrderDetailDTO(saved.getId(), saved.getOrderId(), saved.getDishId(), saved.getQuantity(),
                saved.getUnitPrice(), saved.getUnitCost(), saved.getSubtotal(), saved.getDiscountPercentage());
    }

    public OrderDetailDTO updateDetail(Integer detailId, OrderDetailDTO dto) {
        OrderDetail existing = detailRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("Detail not found: " + detailId));
        existing.setDishId(dto.dishId());
        existing.setQuantity(dto.quantity());
        existing.setUnitPrice(dto.unitPrice());
        existing.setUnitCost(dto.unitCost());
        existing.setSubtotal(dto.subtotal());
        existing.setDiscountPercentage(dto.discountPercentage());
        OrderDetail saved = detailRepository.save(existing);

        // update parent order totals
        Integer orderId = saved.getOrderId();
        Order order = repository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
        BigDecimal total = order.getDetails().stream()
                .map(det -> det.getUnitPrice().multiply(BigDecimal.valueOf(det.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (order.getDiscountPercentage() != null) {
            BigDecimal discount = total.multiply(order.getDiscountPercentage()).divide(BigDecimal.valueOf(100));
            total = total.subtract(discount);
        }
        order.setTotalPrice(total);
        repository.save(order);

        return new OrderDetailDTO(saved.getId(), saved.getOrderId(), saved.getDishId(), saved.getQuantity(),
                saved.getUnitPrice(), saved.getUnitCost(), saved.getSubtotal(), saved.getDiscountPercentage());
    }

    public void deleteDetail(Integer detailId) {
        // find detail to know order id
        OrderDetail existing = detailRepository.findById(detailId)
                .orElseThrow(() -> new IllegalArgumentException("Detail not found: " + detailId));
        Integer orderId = existing.getOrderId();
        detailRepository.deleteById(detailId);

        // update order totals
        Order order = repository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
        order.getDetails().removeIf(d -> d.getId() != null && d.getId().equals(detailId));
        BigDecimal total = order.getDetails().stream()
                .map(det -> det.getUnitPrice().multiply(BigDecimal.valueOf(det.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (order.getDiscountPercentage() != null) {
            BigDecimal discount = total.multiply(order.getDiscountPercentage()).divide(BigDecimal.valueOf(100));
            total = total.subtract(discount);
        }
        order.setTotalPrice(total);
        repository.save(order);
    }

    private Order map(OrderDTO dto) {
        Order o = new Order();
        o.setId(dto.id());
        o.setCustomerId(dto.customerId());
        o.setRestaurantId(dto.restaurantId());
        o.setDate(dto.date());
        o.setTotalPrice(dto.totalPrice());
        o.setDiscountPercentage(dto.discountPercentage());
        o.setPromotionId(dto.promotionId());
        if (dto.details() != null) {
            o.setDetails(dto.details().stream().map(this::map).toList());
        }
        return o;
    }

    private OrderDetail map(OrderDetailDTO dto) {
        OrderDetail d = new OrderDetail();
        d.setId(dto.id());
        d.setOrderId(dto.orderId());
        d.setDishId(dto.dishId());
        d.setQuantity(dto.quantity());
        d.setUnitPrice(dto.unitPrice());
        d.setUnitCost(dto.unitCost());
        d.setSubtotal(dto.subtotal());
        d.setDiscountPercentage(dto.discountPercentage());
        return d;
    }

    private OrderDTO map(Order o) {
        List<OrderDetailDTO> details = o.getDetails().stream().map(d -> new OrderDetailDTO(
                d.getId(), d.getOrderId(), d.getDishId(), d.getQuantity(), d.getUnitPrice(),
                d.getUnitCost(), d.getSubtotal(), d.getDiscountPercentage()
        )).toList();
        return new OrderDTO(o.getId(), o.getCustomerId(), o.getRestaurantId(), o.getDate(), o.getTotalPrice(),
                o.getDiscountPercentage(), o.getPromotionId(), details);
    }
}
