package com.service.restaurantService.infrastructure.persistence.repository;

import com.service.restaurantService.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Integer> {
    @Query("select o from OrderEntity o where o.restaurantId = :restaurantId and o.date between :from and :to")
    List<OrderEntity> findByRestaurantAndDateRange(@Param("restaurantId") UUID restaurantId,
                                                   @Param("from") Instant from,
                                                   @Param("to") Instant to);

    @Query("select o from OrderEntity o where o.customerId = :customerId and o.date between :from and :to")
    List<OrderEntity> findByCustomerAndDateRange(@Param("customerId") UUID customerId,
                                                 @Param("from") Instant from,
                                                 @Param("to") Instant to);
}
