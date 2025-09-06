package com.service.restaurantService;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@EnableFeignClients(basePackages = "com.service.restaurantService.order.infraestructure.outputadapter.feign")
@ConfigurationPropertiesScan
@PropertySource("file:${user.dir}/.env")
@SpringBootApplication
public class RestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

}
