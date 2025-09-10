package com.service.restaurantService.orderdetail.infrastructure.factory;

import com.service.restaurantService.orderdetail.application.ports.output.FindPromotionOutputPort;
import com.service.restaurantService.orderdetail.domain.model.OrderDetailDomainEntity;
import com.service.restaurantService.orderdetail.domain.model.PromotionDomainEntity;
import com.service.restaurantService.orderdetail.infrastructure.inputadapter.dto.OrderDetailResponseDto;
import com.service.restaurantService.orderdetail.infrastructure.outputadapter.feign.dto.PromotionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDetailWithPromotionFactory {
    private final FindPromotionOutputPort promotionOutputPort;

    public OrderDetailWithPromotionFactory(FindPromotionOutputPort promotionOutputPort) {
        this.promotionOutputPort = promotionOutputPort;
    }

    public OrderDetailResponseDto fromDomain(OrderDetailDomainEntity orderDetail) {
        if (orderDetail == null) return null;

        OrderDetailResponseDto dto = new OrderDetailResponseDto();
        dto.id = orderDetail.getId();
        dto.orderId = orderDetail.getOrderId();
        dto.dishId = orderDetail.getDishId();
        dto.quantity = orderDetail.getQuantity();
        dto.unitPrice = orderDetail.getUnitPrice();
        dto.unitCost = orderDetail.getUnitCost();
        dto.subtotal = orderDetail.getSubtotal();
        dto.discountPercentage = orderDetail.getDiscountPercentage();
        dto.promotionId = orderDetail.getPromotionId();
        dto.createdAt = orderDetail.getCreatedAt();

        if (orderDetail.getPromotionId() != null) {
            try {
                PromotionDomainEntity promotion = promotionOutputPort.findById(orderDetail.getPromotionId());
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

    public List<OrderDetailResponseDto> fromDomainList(List<OrderDetailDomainEntity> orderDetails) {
        return orderDetails.stream().map(this::fromDomain).toList();
    }
}
