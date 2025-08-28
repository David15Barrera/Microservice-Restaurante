package com.service.restaurantService.order.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order {

    private Integer id;
    private UUID customerId;
    private UUID restaurantId;
    private LocalDateTime date;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private UUID promotionId;
    // getters/setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID c) {
        this.customerId = c;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID r) {
        this.restaurantId = r;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime d) {
        this.date = d;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal p) {
        this.totalPrice = p;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal v) {
        this.discountPercentage = v;
    }

    public UUID getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(UUID p) {
        this.promotionId = p;
    }
}
