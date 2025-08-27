package com.service.restaurantService.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public OpenAPI restaurantMenuOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Restaurant Menu Service API")
                        .description("API para gestionar restaurantes, platos y pedidos")
                        .version("v1.0"));
    }
}
