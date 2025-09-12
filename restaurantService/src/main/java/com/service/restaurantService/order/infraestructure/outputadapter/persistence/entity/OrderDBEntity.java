package com.service.restaurantService.order.infraestructure.outputadapter.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderDBEntity {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private UUID customerId;
    private UUID restaurantId;
    private OffsetDateTime date;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private UUID promotionId;
    private OffsetDateTime createdAt;
    private String status;

    // getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getCustomerId() { return customerId; }
    public void setCustomerId(UUID customerId) { this.customerId = customerId; }
    public UUID getRestaurantId() { return restaurantId; }
    public void setRestaurantId(UUID restaurantId) { this.restaurantId = restaurantId; }
    public OffsetDateTime getDate() { return date; }
    public void setDate(OffsetDateTime date) { this.date = date; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public BigDecimal getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(BigDecimal discountPercentage) { this.discountPercentage = discountPercentage; }
    public UUID getPromotionId() { return promotionId; }
    public void setPromotionId(UUID promotionId) { this.promotionId = promotionId; }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status){
        this.status = this.status;
    }
}
