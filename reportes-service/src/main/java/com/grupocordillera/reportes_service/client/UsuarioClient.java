package com.grupocordillera.reportes_service.client;

import com.grupocordillera.reportes_service.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UsuarioClient {
    @Autowired
    private WebClient webClient;
    
    public UsuarioDTO obtenerUsuarioPorId(Integer idUsuario) {
        return webClient
                .get()
                .uri("/api/v1/usuarios/{id}", idUsuario)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<UsuarioDTO>() {})
                .block();
    }
}
