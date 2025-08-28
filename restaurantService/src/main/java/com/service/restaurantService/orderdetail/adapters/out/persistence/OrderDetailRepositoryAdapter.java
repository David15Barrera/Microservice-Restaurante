package com.service.restaurantService.orderdetail.adapters.out.persistence;

import com.service.restaurantService.orderdetail.domain.model.OrderDetail;
import com.service.restaurantService.orderdetail.domain.port.OrderDetailRepositoryPort;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDetailRepositoryAdapter implements OrderDetailRepositoryPort {

    private final OrderDetailJpaRepository jpa;

    public OrderDetailRepositoryAdapter(OrderDetailJpaRepository jpa){
        this.jpa=jpa;
    }

    private static OrderDetail toDomain(OrderDetailEntity e){
        if(e==null) return null;
        OrderDetail d=new OrderDetail();

        d.setId(e.getId());
        d.setOrderId(e.getOrderId());
        d.setDishId(e.getDishId());
        d.setQuantity(e.getQuantity());
        d.setUnitPrice(e.getUnitPrice());
        d.setUnitCost(e.getUnitCost());
        d.setSubtotal(e.getSubtotal());
        d.setDiscountPercentage(e.getDiscountPercentage());
        d.setPromotionId(e.getPromotionId());
        return d;
    }

    private static OrderDetailEntity toEntity(OrderDetail d){
        if(d==null) return null;
        OrderDetailEntity e=new OrderDetailEntity();
        e.setId(d.getId());
        e.setOrderId(d.getOrderId());
        e.setDishId(d.getDishId());
        e.setQuantity(d.getQuantity());
        e.setUnitPrice(d.getUnitPrice());
        e.setUnitCost(d.getUnitCost());
        e.setSubtotal(d.getSubtotal());
        e.setDiscountPercentage(d.getDiscountPercentage());
        e.setPromotionId(d.getPromotionId());
        return e;
    }

    @Override
    public OrderDetail save(OrderDetail d){
        return toDomain(jpa.save(toEntity(d)));
    }

    @Override public Optional<OrderDetail> findById(Integer id){
        return jpa.findById(id).map(OrderDetailRepositoryAdapter::toDomain);
    }

    @Override public List<OrderDetail> findByOrderId(Integer orderId){
        return jpa.findByOrderId(orderId).stream().map(OrderDetailRepositoryAdapter::toDomain).collect(Collectors.toList());
    }

    @Override public List<OrderDetail> findAll(){
        return jpa.findAll().stream().map(OrderDetailRepositoryAdapter::toDomain).collect(Collectors.toList());
    }
    @Override public void deleteById(Integer id){
        jpa.deleteById(id);
    }
}
