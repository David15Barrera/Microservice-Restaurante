package com.service.restaurantService.orderdetail.infrastructure.inputadapter.rest;

import com.service.restaurantService.orderdetail.application.ports.input.*;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto.OrderDetailRequestDto;
import com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto.OrderDetailResponseDto;
import com.service.restaurantService.orderdetail.infrastructure.inputadapter.mapper.OrderDetailMapperRest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailControllerAdapter {

    private final CreateOrderDetailInputPort createUseCase;
    private final UpdateOrderDetailInputPort updateUseCase;
    private final GetOrderDetailByIdInputPort getByIdUseCase;
    private final ListAllOrderDetailInputPort listAllUseCase;
    private final DeleteOrderDetailInputPort deleteUseCase;

    public OrderDetailControllerAdapter(CreateOrderDetailInputPort createUseCase,
                                        UpdateOrderDetailInputPort updateUseCase,
                                        GetOrderDetailByIdInputPort getByIdUseCase,
                                        ListAllOrderDetailInputPort listAllUseCase,
                                        DeleteOrderDetailInputPort deleteUseCase) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listAllUseCase = listAllUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<OrderDetailResponseDto> create(@RequestBody OrderDetailRequestDto dto) {
        OrderDetailDomainEntity domain = OrderDetailMapperRest.toDomain(dto);
        OrderDetailDomainEntity created = createUseCase.create(domain);
        return ResponseEntity.ok(OrderDetailMapperRest.toResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailResponseDto> getById(@PathVariable Integer id) {
        OrderDetailDomainEntity d = getByIdUseCase.getById(id);
        return ResponseEntity.ok(OrderDetailMapperRest.toResponse(d));
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailResponseDto>> listAll() {
        List<OrderDetailDomainEntity> all = listAllUseCase.listAll();
        List<OrderDetailResponseDto> resp = all.stream().map(OrderDetailMapperRest::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailResponseDto> update(@PathVariable Integer id, @RequestBody OrderDetailRequestDto dto) {
        OrderDetailDomainEntity domain = OrderDetailMapperRest.toDomain(dto);
        domain.setId(id);
        OrderDetailDomainEntity updated = updateUseCase.update(domain);
        return ResponseEntity.ok(OrderDetailMapperRest.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deleteUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
