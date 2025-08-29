package com.service.restaurantService.order.adapters.out.persistence;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity @Table(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="customer_id", columnDefinition="uuid", nullable=false)
    private UUID customerId;

    @Column(name="restaurant_id", columnDefinition="uuid", nullable=false)
    private UUID restaurantId;

    @Column(name="date")
    private java.time.LocalDateTime date;

    @Column(name="total_price", precision=10, scale=2, nullable=false)
    private BigDecimal totalPrice;

    @Column(name="discount_percentage", precision=5, scale=2)
    private BigDecimal discountPercentage;

    @Column(name="promotion_id", columnDefinition="uuid")
    private UUID promotionId;


    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    // getters/setters
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public UUID getCustomerId(){
        return customerId;
    }

    public void setCustomerId(UUID c){
        this.customerId=c;
    }

    public UUID getRestaurantId(){
        return restaurantId;
    }

    public void setRestaurantId(UUID r){
        this.restaurantId=r;
    }

    public java.time.LocalDateTime getDate(){
        return date;
    }

    public void setDate(java.time.LocalDateTime d){
        this.date=d;
    }

    public BigDecimal getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal p){
        this.totalPrice=p;
    }

    public BigDecimal getDiscountPercentage(){
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal d){
        this.discountPercentage=d;
    }

    public UUID getPromotionId(){
        return promotionId;
    }

    public void setPromotionId(UUID p){
        this.promotionId=p;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
