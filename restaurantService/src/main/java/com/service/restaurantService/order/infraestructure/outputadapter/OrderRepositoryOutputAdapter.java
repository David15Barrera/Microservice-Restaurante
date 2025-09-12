package com.service.restaurantService.order.infraestructure.outputadapter;

import com.service.restaurantService.order.application.ports.output.DeleteOrderOutputPort;
import com.service.restaurantService.order.application.ports.output.FindOrdersByCustomerOutPort;
import com.service.restaurantService.order.application.ports.output.FindOrdersByRestaurantOutputPort;
import com.service.restaurantService.order.application.ports.output.SaveOrderOutputPort;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import com.service.restaurantService.order.infraestructure.outputadapter.persistence.entity.OrderDBEntity;
import com.service.restaurantService.order.infraestructure.outputadapter.persistence.mapper.OrderMapper;
import com.service.restaurantService.order.infraestructure.outputadapter.persistence.repository.OrderDBRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryOutputAdapter implements
        SaveOrderOutputPort,
        DeleteOrderOutputPort,
        FindOrdersByRestaurantOutputPort,
        FindOrdersByCustomerOutPort {

    private final OrderDBRepository repo;

    public OrderRepositoryOutputAdapter(OrderDBRepository repo) {
        this.repo = repo;
    }

    @Override
    public OrderDomainEntity save(OrderDomainEntity order) {
        OrderDBEntity e = OrderMapper.toEntity(order);
        OrderDBEntity saved = repo.save(e);
        return OrderMapper.toDomain(saved);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<OrderDomainEntity> findById(UUID id) {
        return repo.findById(id).map(OrderMapper::toDomain);
    }

    @Override
    public List<OrderDomainEntity> findAll() {
        return repo.findAll().stream().map(OrderMapper::toDomain).collect(Collectors.toList());
    }


    @Override
    public List<OrderDomainEntity> findByRestaurantId(UUID restaurantId) {
        return repo.findByRestaurantId(restaurantId)
                .stream()
                .map(OrderMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDomainEntity> findByCustomer(UUID customerId){
        return repo.findByCustomerId(customerId)
                .stream()
                .map(OrderMapper::toDomain)
                .collect(Collectors.toList());
    }
}
