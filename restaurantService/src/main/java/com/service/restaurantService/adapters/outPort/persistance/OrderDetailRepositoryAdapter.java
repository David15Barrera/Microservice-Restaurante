package com.service.restaurantService.adapters.outPort.persistance;

import com.service.restaurantService.adapters.outPort.persistance.entity.OrderDetailEntity;
import com.service.restaurantService.adapters.outPort.persistance.mapper.PersistenceMapper;
import com.service.restaurantService.adapters.outPort.persistance.repository.OrderDetailJpaRepository;
import com.service.restaurantService.domain.model.orderDetail;
import com.service.restaurantService.domain.ports.OrderDetailRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDetailRepositoryAdapter implements OrderDetailRepositoryPort {

    private final OrderDetailJpaRepository jpa;

    public OrderDetailRepositoryAdapter(OrderDetailJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public orderDetail save(orderDetail detail) {
        OrderDetailEntity saved = jpa.save(PersistenceMapper.toEntity(detail));
        return PersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<orderDetail> findById(Integer id) {
        return jpa.findById(id).map(PersistenceMapper::toDomain);
    }

    @Override
    public List<orderDetail> findByOrderId(Integer orderId) {
        return jpa.findByOrderId(orderId).stream().map(PersistenceMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<orderDetail> findAll() {
        return jpa.findAll().stream().map(PersistenceMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
