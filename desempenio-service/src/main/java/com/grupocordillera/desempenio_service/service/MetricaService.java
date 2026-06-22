package com.grupocordillera.desempenio_service.service;

import com.grupocordillera.desempenio_service.client.SucursalClient;
import com.grupocordillera.desempenio_service.dto.MetricaSucursalDTO;
import com.grupocordillera.desempenio_service.dto.SucursalDTO;
import com.grupocordillera.desempenio_service.model.Metrica;
import com.grupocordillera.desempenio_service.repository.MetricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetricaService {
    @Autowired
    private MetricaRepository repository;

    public List<Metrica> getMetricas() {
        return repository.findAll();
    }

    public Optional<Metrica> getMetrica(int id) {
        return repository.findById(id);
    }

    public Metrica saveMetrica(Metrica metrica) {
        return repository.save(metrica);
    }

    public Metrica updateMetrica(int id, Metrica metrica) {
        Optional<Metrica> existe = getMetrica(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("Metrica no encontrada");
        } else {
            return repository.save(metrica);
        }
    }

    public void deleteMetrica(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Metrica no encontrada");
        }
    }

    @Autowired
    private SucursalClient sucursalClient;

    public MetricaSucursalDTO getMetricaConSucursal(Integer idMetrica, Integer idSucursal) {


        Metrica metrica =
                repository.findById(idMetrica).orElse(null);

        SucursalDTO sucursal =
                sucursalClient.obtenerSucursal(idSucursal);

        MetricaSucursalDTO dto =
                new MetricaSucursalDTO();

        dto.setIdMetrica(metrica.getId());
        dto.setNombre(metrica.getNombre());
        dto.setValorActual(metrica.getValorActual());
        dto.setMetaObjetivo(metrica.getMetaObjetivo());
        dto.setUnidadMedida(metrica.getUnidadMedida());
        dto.setSucursal(sucursal);
        dto.setUltimaActualizacion(metrica.getUltimaActualizacion());

        return dto;
    }
}


