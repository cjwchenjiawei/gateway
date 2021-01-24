package com.cjw.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SysConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("oneId",
                r -> r.path("/guest/**")
                        .uri("lb://guestSys")
                      ).build();
        routes.route("twoId",
                r -> r.path("/order/**")
                        .uri("lb://orderSys")).build();
        routes.route("threeId",
                r -> r.path("/movieStock/**")
                        .uri("lb://cinemaSys")).build();
        routes.route("fourId",
                r -> r.path("/power/**")
                        .uri("lb://powerSys")).build();

        return routes.build();
    }
}
