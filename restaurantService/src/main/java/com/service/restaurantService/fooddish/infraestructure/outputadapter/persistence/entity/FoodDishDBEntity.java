package com.service.restaurantService.fooddish.infraestructure.outputadapter.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "food_dishes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDishDBEntity {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "restaurant_id", columnDefinition = "uuid")
    private UUID restaurantId;

    private String name;
    private String description;
    private BigDecimal price;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

}
