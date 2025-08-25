package com.service.restaurantService.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class order {
    private Integer id;
    private UUID customerId;
    private UUID restaurantId;
    private LocalDateTime date;
    private BigDecimal totalPrice;
    private BigDecimal discountPercentage;
    private UUID promotionId;

    public  order() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public UUID getCustomerId() { return customerId; }
    public void setCustomerId(UUID customerId) { this.customerId = customerId; }
    public UUID getRestaurantId() { return restaurantId; }
    public void setRestaurantId(UUID restaurantId) { this.restaurantId = restaurantId; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public BigDecimal getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(BigDecimal discountPercentage) { this.discountPercentage = discountPercentage; }
    public UUID getPromotionId() { return promotionId; }
    public void setPromotionId(UUID promotionId) { this.promotionId = promotionId; }
}
