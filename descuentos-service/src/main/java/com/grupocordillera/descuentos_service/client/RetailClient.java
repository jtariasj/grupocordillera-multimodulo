package com.grupocordillera.descuentos_service.client;

import com.grupocordillera.descuentos_service.dto.MetodoPagoDTO;
import com.grupocordillera.descuentos_service.dto.VentaFisicaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RetailClient {

    @Autowired
    private WebClient retailWebClient;


    public List<VentaFisicaDTO> obtenerVentas() {
        return retailWebClient
                .get()
                .uri("/api/v1/ventas")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<VentaFisicaDTO>>() {})
                .block();
    }

    public List<VentaFisicaDTO> obtenerVentasActivas() {
        return retailWebClient
                .get()
                .uri("/api/v1/ventas/activas")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<VentaFisicaDTO>>() {})
                .block();
    }


    public List<MetodoPagoDTO> obtenerMetodosPago() {
        return retailWebClient
                .get()
                .uri("/api/v1/metodos-pago")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<MetodoPagoDTO>>() {})
                .block();
    }
}
