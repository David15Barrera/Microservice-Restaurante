package com.service.restaurantService.orderdetail.adapters.out.persistence;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="order_details")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "dish_id", nullable = false)
    private Integer dishId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "unit_cost", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitCost;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "discount_percentage", precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "promotion_id", columnDefinition = "uuid")
    private UUID promotionId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;



    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public Integer getOrderId(){
        return orderId;
    }
    public void setOrderId(Integer o){
        this.orderId=o;
    }
    public Integer getDishId(){
        return dishId;
    }
    public void setDishId(Integer d){
        this.dishId=d;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer q){
        this.quantity=q;
    }
    public BigDecimal getUnitPrice(){
        return unitPrice;
    }
    public void setUnitPrice(BigDecimal p){
        this.unitPrice=p;
    }
    public BigDecimal getUnitCost(){
        return unitCost;
    }
    public void setUnitCost(BigDecimal c){
        this.unitCost=c;
    }
    public BigDecimal getSubtotal(){
        return subtotal;
    }
    public void setSubtotal(BigDecimal s){
        this.subtotal=s;
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
    public java.time.LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(java.time.LocalDateTime t){
        this.createdAt=t;
    }
}
