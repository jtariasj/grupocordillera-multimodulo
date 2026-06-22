package com.grupocordillera.reportes_service.service;

import com.grupocordillera.reportes_service.client.UsuarioClient;
import com.grupocordillera.reportes_service.dto.UsuarioDTO;
import com.grupocordillera.reportes_service.model.Reporte;
import com.grupocordillera.reportes_service.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository repository;
    @Autowired
    private UsuarioClient usuarioClient;

    public List<Reporte> getReportes() {
        return repository.findAll();
    }

    public Optional<Reporte> getReporte(Integer id) {
        return repository.findById(id);
    }

    public Reporte saveReporte(Reporte reporte) {
        return repository.save(reporte);
    }

    public Reporte updateReporte(Integer id, Reporte reporte) {
        Optional<Reporte> existe = getReporte(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("Reporte no encontrado");
        } else {

            return repository.save(reporte);
        }
    }

    public void deleteReporte(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Reporte no encontrado");
        }
    }
    public UsuarioDTO getUsuario(Integer id) {
        return usuarioClient.obtenerUsuarioPorId(id);
    }
}