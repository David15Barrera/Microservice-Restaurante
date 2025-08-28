package com.service.restaurantService.orderdetail.adapters.out.persistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailJpaRepository extends JpaRepository<OrderDetailEntity, Integer> {
    java.util.List<OrderDetailEntity> findByOrderId(Integer orderId);
}
