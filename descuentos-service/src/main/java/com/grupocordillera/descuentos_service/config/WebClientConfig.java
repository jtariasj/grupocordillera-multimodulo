package com.grupocordillera.descuentos_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient retailWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8085") // retail-service
                .build();
    }

    @Bean
    public WebClient finanzasWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8086") // retail-service
                .build();
    }
}
