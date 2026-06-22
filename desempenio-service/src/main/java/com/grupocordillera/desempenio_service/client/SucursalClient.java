package com.grupocordillera.desempenio_service.client;

import com.grupocordillera.desempenio_service.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SucursalClient {

    @Autowired
    private WebClient webClient;

    public SucursalDTO obtenerSucursal(Integer id) {

        return webClient
                .get()
                .uri("/api/v1/sucursales/{id}", id)
                .retrieve()
                .bodyToMono(SucursalDTO.class)
                .block();
    }
}
