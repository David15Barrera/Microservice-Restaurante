package com.service.restaurantService.config;

import com.service.restaurantService.domain.ports.DishRepositoryPort;
import com.service.restaurantService.domain.ports.OrderDetailRepositoryPort;
import com.service.restaurantService.domain.ports.OrderRepositoryPort;
import com.service.restaurantService.domain.ports.RestaurantRepositoryPort;
import com.service.restaurantService.domain.useCase.DishService;
import com.service.restaurantService.domain.useCase.OrderDetailService;
import com.service.restaurantService.domain.useCase.OrderService;
import com.service.restaurantService.domain.useCase.RestaurantService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RestaurantService restaurantService(RestaurantRepositoryPort repository) {
        return new RestaurantService(repository);
    }

    @Bean
    public DishService dishService(DishRepositoryPort repository) {
        return new DishService(repository);
    }

    @Bean
    public OrderService orderService(OrderRepositoryPort repository) {
        return new OrderService(repository);
    }

    @Bean
    public OrderDetailService orderDetailService(OrderDetailRepositoryPort repository) {
        return new OrderDetailService(repository);
    }
}
