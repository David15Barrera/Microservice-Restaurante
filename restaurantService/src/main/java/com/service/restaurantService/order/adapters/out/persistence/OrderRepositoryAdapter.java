package com.service.restaurantService.order.adapters.out.persistence;

import com.service.restaurantService.order.domain.model.Order;
import com.service.restaurantService.order.domain.port.OrderRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {
    private final OrderJpaRepository jpa;

    public OrderRepositoryAdapter(OrderJpaRepository jpa){
        this.jpa=jpa;
    }

    private static Order toDomain(OrderEntity e){
        if(e==null) return null;
        Order o=new Order();
        o.setId(e.getId());
        o.setCustomerId(e.getCustomerId());
        o.setRestaurantId(e.getRestaurantId());
        o.setDate(e.getDate());
        o.setTotalPrice(e.getTotalPrice());
        o.setDiscountPercentage(e.getDiscountPercentage());
        o.setPromotionId(e.getPromotionId());
        return o;
    }

    private static OrderEntity toEntity(Order o){
        if(o==null) return null;
        OrderEntity e=new OrderEntity();
        e.setId(o.getId());
        e.setCustomerId(o.getCustomerId());
        e.setRestaurantId(o.getRestaurantId());
        e.setDate(o.getDate()); e.setTotalPrice(o.getTotalPrice());
        e.setDiscountPercentage(o.getDiscountPercentage());
        e.setPromotionId(o.getPromotionId());
        return e;
    }

    @Override
    public Order save(Order o){
        return toDomain(jpa.save(toEntity(o)));
    }

    @Override
    public Optional<Order> findById(Integer id){
        return jpa.findById(id).map(OrderRepositoryAdapter::toDomain);
    }

    @Override
    public List<Order> findAll(){
        return jpa.findAll().stream().map(OrderRepositoryAdapter::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Order> findByRestaurantId(UUID restaurantId){
        return jpa.findByRestaurantId(restaurantId).stream().map(OrderRepositoryAdapter::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id){
        jpa.deleteById(id);
    }
}
