package com.chungvv3.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("image-service", r -> r.path("/images/**")
                        .uri("lb://image-service"))

                .route("gallery-service", r -> r.path("/gallery/**")
                        .uri("lb://gallery-service"))
                .build();
    }

}
