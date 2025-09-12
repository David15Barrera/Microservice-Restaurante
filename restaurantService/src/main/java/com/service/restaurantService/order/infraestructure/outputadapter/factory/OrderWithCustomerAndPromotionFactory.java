package com.service.restaurantService.order.infraestructure.outputadapter.factory;

import com.service.restaurantService.order.application.ports.output.FindCustomerOutputPort;
import com.service.restaurantService.order.application.ports.output.FindPromotionOutputPort;
import com.service.restaurantService.order.domain.model.CustomerDomainEntity;
import com.service.restaurantService.order.domain.model.OrderDomainEntity;
import com.service.restaurantService.order.domain.model.PromotionDomainEntity;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.CustomerResponse;
import com.service.restaurantService.order.infraestructure.inputadapter.dto.OrderResponseDto;
import com.service.restaurantService.order.infraestructure.outputadapter.feign.dto.PromotionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderWithCustomerAndPromotionFactory {

    private final FindCustomerOutputPort customerOutputPort;
    private final FindPromotionOutputPort promotionOutputPort;

    public OrderWithCustomerAndPromotionFactory(
            FindCustomerOutputPort customerOutputPort,
            FindPromotionOutputPort promotionOutputPort) {
        this.customerOutputPort = customerOutputPort;
        this.promotionOutputPort = promotionOutputPort;
    }

    public OrderResponseDto fromDomain(OrderDomainEntity order) {
        if (order == null) return null;

        OrderResponseDto dto = new OrderResponseDto();
        dto.id = order.getId();
        dto.customerId = order.getCustomerId();
        dto.restaurantId = order.getRestaurantId();
        dto.date = order.getDate();
        dto.totalPrice = order.getTotalPrice();
        dto.discountPercentage = order.getDiscountPercentage();
        dto.promotionId = order.getPromotionId();
        dto.status = order.getStatus();
        dto.createdAt = order.getCreatedAt();

        if (order.getCustomerId() != null) {
            try {
                CustomerDomainEntity customer = customerOutputPort.findById(order.getCustomerId());
                CustomerResponse cr = new CustomerResponse();
                cr.id = customer.getId().toString();
                cr.fullName = customer.getFullName();
                cr.cui = customer.getCui();
                cr.phone = customer.getPhone();
                cr.email = customer.getEmail();
                cr.address = customer.getAddress();
                cr.loyaltyPoints = customer.getLoyaltyPoints();
                dto.customer = cr;
            } catch (Exception e) {
                dto.customer = null;
            }
        }

        // Obtener promotion si existe
        if (order.getPromotionId() != null) {
            try {
                PromotionDomainEntity promotion = promotionOutputPort.findById(order.getPromotionId());
                PromotionResponse pr = new PromotionResponse();
                pr.id = promotion.getId();
                pr.name = promotion.getName();
                pr.description = promotion.getDescription();
                pr.type = promotion.getType();
                pr.discountPercentage = promotion.getDiscountPercentage();
                pr.startDate = promotion.getStartDate();
                pr.endDate = promotion.getEndDate();
                pr.hotelId = promotion.getHotelId();
                pr.restaurantId = promotion.getRestaurantId();
                pr.customerId = promotion.getCustomerId();
                pr.roomId = promotion.getRoomId();
                pr.dishId = promotion.getDishId();
                dto.promotion = pr;
            } catch (Exception e) {
                dto.promotion = null;
            }
        }

        return dto;
    }

    public List<OrderResponseDto> fromDomainList(List<OrderDomainEntity> orders) {
        return orders.stream().map(this::fromDomain).toList();
    }

}
