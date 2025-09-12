package com.service.restaurantService.order.infraestructure.inputadapter.rest;

import com.service.restaurantService.order.application.ports.input.*;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderRequestDto;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderResponseDto;
import com.service.restaurantService.order.infraestructure.inputadapter.mapper.OrderMapperRest;
import com.service.restaurantService.order.infraestructure.outputadapter.factory.OrderWithCustomerAndPromotionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderControllerAdapter {

    private final ListAllOrderInputPort listAllUseCase;
    private final CreateOrderInputPort createUseCase;
    private final GetOrderByIdInputPort getUseCase;
    private final UpdateOrderInputPort updateUseCase;
    private final DeleteOrderInputPort deleteUseCase;
    private final FindOrdersByRestaurantInputPort findOrdersByRestaurantUseCase;
    private final FindOrderByCustomerInputPort findOrderByCustomerInputPort;
    private final OrderWithCustomerAndPromotionFactory orderFactory;

    public OrderControllerAdapter(ListAllOrderInputPort listAllUseCase,
                                  CreateOrderInputPort createUseCase,
                                  GetOrderByIdInputPort getUseCase,
                                  UpdateOrderInputPort updateUseCase,
                                  DeleteOrderInputPort deleteUseCase,
                                  FindOrdersByRestaurantInputPort findOrdersByRestaurantUseCase, FindOrderByCustomerInputPort findOrderByCustomerInputPort, OrderWithCustomerAndPromotionFactory orderFactory) {
        this.listAllUseCase = listAllUseCase;
        this.createUseCase = createUseCase;
        this.getUseCase = getUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
        this.findOrdersByRestaurantUseCase = findOrdersByRestaurantUseCase;
        this.findOrderByCustomerInputPort = findOrderByCustomerInputPort;
        this.orderFactory = orderFactory;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> listAll() {
        List<OrderDomainEntity> all = listAllUseCase.listAll();
        List<OrderResponseDto> response = orderFactory.fromDomainList(all);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getById(@PathVariable UUID id) {
        OrderDomainEntity order = getUseCase.getById(id);
        OrderResponseDto response = orderFactory.fromDomain(order);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderRequestDto dto) {
        OrderDomainEntity domain = OrderMapperRest.toDomain(dto);
        OrderDomainEntity created = createUseCase.create(domain);
        OrderResponseDto response = orderFactory.fromDomain(created);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> update(@PathVariable UUID id, @RequestBody OrderRequestDto dto) {
        OrderDomainEntity domain = OrderMapperRest.toDomain(dto);
        domain.setId(id);
        OrderDomainEntity updated = updateUseCase.update(domain);
        OrderResponseDto response = orderFactory.fromDomain(updated);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/by-restaurant/{restaurantId}")
    public ResponseEntity<List<OrderResponseDto>> getByRestaurantId(@PathVariable UUID restaurantId) {
        List<OrderDomainEntity> orders = findOrdersByRestaurantUseCase.findByRestaurantId(restaurantId);
        List<OrderResponseDto> response = orderFactory.fromDomainList(orders);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<List<OrderResponseDto>> getByCustomer(@PathVariable UUID customerId){
        List<OrderDomainEntity> orders = findOrderByCustomerInputPort.findByCustomer(customerId);
        List<OrderResponseDto> response = orderFactory.fromDomainList(orders);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
