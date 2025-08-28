package com.service.restaurantService.fooddish.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class FoodDish {
    private Integer id;
    private UUID restaurantId;
    private String name;
    private String description;
    private BigDecimal price;

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
    public void setName(String n) {
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
}
