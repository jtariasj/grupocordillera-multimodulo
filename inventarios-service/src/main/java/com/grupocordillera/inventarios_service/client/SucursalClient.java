package com.grupocordillera.inventarios_service.client;

import com.grupocordillera.inventarios_service.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class SucursalClient {

    @Autowired
    private WebClient webClient;

    public List<SucursalDTO> obtenerSucursales(){
        return webClient
                .get()
                .uri("/api/v1/sucursales")
                .retrieve()
                .bodyToMono(
                        new ParameterizedTypeReference<List<SucursalDTO>>(){}
                )
                .block();
    }

    public SucursalDTO obtenerSucursal(Integer id){
        return webClient
                .get()
                .uri("/api/v1/sucursales/{id}")
                .retrieve()
                .bodyToMono(
                        new ParameterizedTypeReference<SucursalDTO>(){}
                )
                .block();
    }
}
