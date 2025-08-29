package com.service.restaurantService.fooddish.adapters.out.persistence;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="food_dishes")
public class FoodDishEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="restaurant_id", columnDefinition="uuid", nullable=false)
    private UUID restaurantId;

    @Column(name="name", length=100, nullable=false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price", precision=10, scale=2, nullable=false)
    private BigDecimal price;

    @Column(name="created_at")
    private java.time.LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public UUID getRestaurantId(){
        return restaurantId;
    }

    public void setRestaurantId(UUID r){
        this.restaurantId=r;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        this.name=n;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String d){
        this.description=d;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal p){
        this.price=p;
    }

    public java.time.LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime t){
        this.createdAt=t;
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
