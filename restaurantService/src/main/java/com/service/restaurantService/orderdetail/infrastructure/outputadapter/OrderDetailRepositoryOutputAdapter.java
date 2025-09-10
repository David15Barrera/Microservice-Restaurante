package com.service.restaurantService.orderdetail.infrastructure.outputadapter;

import com.service.restaurantService.orderdetail.application.ports.output.SaveOrderDetailOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.entity.OrderDetailDBEntity;
import com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.mapper.OrderDetailMapper;
import com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.repository.OrderDetailDBRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDetailRepositoryOutputAdapter implements SaveOrderDetailOutputPort {

    private final OrderDetailDBRepository repo;

    public OrderDetailRepositoryOutputAdapter(OrderDetailDBRepository repo) { this.repo = repo; }

    @Override
    public OrderDetailDomainEntity save(OrderDetailDomainEntity d) {
        OrderDetailDBEntity e = OrderDetailMapper.toEntity(d);
        OrderDetailDBEntity saved = repo.save(e);
        return OrderDetailMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<OrderDetailDomainEntity> findById(Integer id) {
        return repo.findById(id).map(OrderDetailMapper::toDomain);
    }

    @Override
    public List<OrderDetailDomainEntity> findAll() {
        return repo.findAll().stream().map(OrderDetailMapper::toDomain).collect(Collectors.toList());
    }
}
