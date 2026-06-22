package com.grupocordillera.ecommerce_service.client;

import com.grupocordillera.ecommerce_service.dto.MetodoPagoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MetodoPagoClient {

    @Autowired
    private WebClient webClient;

    public MetodoPagoDTO obtenerMetodoPago(Integer id) {

        return webClient
                .get()
                .uri("/api/v1/metodos-pago/{id}", id)
                .retrieve()
                .bodyToMono(MetodoPagoDTO.class)
                .block();
    }
}
