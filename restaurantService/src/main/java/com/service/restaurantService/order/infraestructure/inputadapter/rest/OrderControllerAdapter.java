package com.service.restaurantService.order.infraestructure.inputadapter.rest;

import com.service.restaurantService.order.application.ports.input.*;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderRequestDto;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderResponseDto;
import com.service.restaurantService.order.infraestructure.inputadapter.mapper.OrderMapperRest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderControllerAdapter {

    private final ListAllOrderInputPort listAllUseCase;
    private final CreateOrderInputPort createUseCase;
    private final GetOrderByIdInputPort getUseCase;
    private final UpdateOrderInputPort updateUseCase;
    private final DeleteOrderInputPort deleteUseCase;

    public OrderControllerAdapter(ListAllOrderInputPort listAllUseCase,
                                  CreateOrderInputPort createUseCase,
                                  GetOrderByIdInputPort getUseCase,
                                  UpdateOrderInputPort updateUseCase,
                                  DeleteOrderInputPort deleteUseCase) {
        this.listAllUseCase = listAllUseCase;
        this.createUseCase = createUseCase;
        this.getUseCase = getUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> listAll() {
        List<OrderDomainEntity> all = listAllUseCase.listAll();
        List<OrderResponseDto> resp = all.stream().map(OrderMapperRest::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getById(@PathVariable Integer id) {
        OrderDomainEntity d = getUseCase.getById(id);
        return ResponseEntity.ok(OrderMapperRest.toResponse(d));
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderRequestDto dto) {
        OrderDomainEntity domain = OrderMapperRest.toDomain(dto);
        OrderDomainEntity created = createUseCase.create(domain);
        return ResponseEntity.status(201).body(OrderMapperRest.toResponse(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> update(@PathVariable Integer id, @RequestBody OrderRequestDto dto) {
        OrderDomainEntity domain = OrderMapperRest.toDomain(dto);
        domain.setId(id);
        OrderDomainEntity updated = updateUseCase.update(domain);
        return ResponseEntity.ok(OrderMapperRest.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deleteUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
