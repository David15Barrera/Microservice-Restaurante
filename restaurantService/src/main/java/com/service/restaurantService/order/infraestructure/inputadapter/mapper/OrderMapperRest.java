package com.service.restaurantService.order.infraestructure.inputadapter.mapper;

import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.CustomerResponse;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderRequestDto;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderResponseDto;

import java.time.OffsetDateTime;

public class OrderMapperRest {
    public static OrderResponseDto toResponse(OrderDomainEntity d) {
        if (d == null) return null;
        OrderResponseDto r = new OrderResponseDto();
        r.id = d.getId();
        r.customerId = d.getCustomerId();
        r.restaurantId = d.getRestaurantId();
        r.date = d.getDate();
        r.totalPrice = d.getTotalPrice();
        r.discountPercentage = d.getDiscountPercentage();
        r.promotionId = d.getPromotionId();
        r.createdAt = d.getCreatedAt();

        // Mapear y asignar el objeto Customer si existe
        if (d.getCustomer() != null) {
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.id = d.getCustomer().getId().toString();
            customerResponse.fullName = d.getCustomer().getFullName();
            customerResponse.cui = d.getCustomer().getCui();
            customerResponse.phone = d.getCustomer().getPhone();
            customerResponse.email = d.getCustomer().getEmail();
            customerResponse.address = d.getCustomer().getAddress();
            customerResponse.loyaltyPoints = d.getCustomer().getLoyaltyPoints();
            r.customer = customerResponse;
        }

        return r;
    }

    public static OrderDomainEntity toDomain(OrderRequestDto dto) {
        if (dto == null) return null;
        OrderDomainEntity d = new OrderDomainEntity();
        d.setCustomerId(dto.customerId);
        d.setRestaurantId(dto.restaurantId);
        d.setTotalPrice(dto.totalPrice);
        d.setDiscountPercentage(dto.discountPercentage);
        d.setPromotionId(dto.promotionId);
        d.setDate(OffsetDateTime.now());
        return d;
    }
}