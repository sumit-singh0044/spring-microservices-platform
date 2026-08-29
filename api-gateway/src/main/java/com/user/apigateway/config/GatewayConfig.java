package com.user.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> authServiceRoute() {
        return route("auth-service-route")
                .route(path("/api/login/**"), http())
                .filter(lb("auth-service"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userInfoRoute() {
        return route("user-info-route")
                .route(path("/api/users/**"), http())
                .filter(lb("UserInfo"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> addressRoute() {
        return route("address-route")
                .route(path("/api/address/**"), http())
                .filter(lb("UserInfo"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userPaymentRoute() {
        return route("user-payment-route")
                .route(path("/accounts/**"), http())
                .filter(lb("UserPayment"))
                .build();
    }
}
