package com.service.restaurantService.config;

import com.service.restaurantService.fooddish.application.FoodDishService;
import com.service.restaurantService.fooddish.domain.port.FoodDishRepositoryPort;
import com.service.restaurantService.order.application.OrderService;
import com.service.restaurantService.order.domain.port.OrderRepositoryPort;
import com.service.restaurantService.orderdetail.application.OrderDetailService;
import com.service.restaurantService.orderdetail.domain.port.OrderDetailRepositoryPort;
import com.service.restaurantService.restaurant.application.RestaurantService;
import com.service.restaurantService.restaurant.domain.port.RestaurantRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RestaurantService restaurantService(RestaurantRepositoryPort r){
        return new RestaurantService(r);
    }

    @Bean
    public FoodDishService foodDishService(FoodDishRepositoryPort r){
        return new FoodDishService(r);
    }

    @Bean
    public OrderService orderService(OrderRepositoryPort r){
        return new OrderService(r);
    }

    @Bean
    public OrderDetailService orderDetailService(OrderDetailRepositoryPort r){
        return new OrderDetailService(r);
    }
}
