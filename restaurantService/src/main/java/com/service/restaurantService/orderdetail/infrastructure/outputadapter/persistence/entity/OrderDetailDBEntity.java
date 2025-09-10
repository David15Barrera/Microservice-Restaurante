package com.service.restaurantService.orderdetail.infrastructure.outputadapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetailDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "dish_id")
    private UUID dishId;

    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;

    private BigDecimal subtotal;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    @Column(name = "promotion_id")
    private UUID promotionId;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

}
