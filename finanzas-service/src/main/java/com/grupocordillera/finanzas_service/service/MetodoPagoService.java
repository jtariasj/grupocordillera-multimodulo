package com.grupocordillera.finanzas_service.service;

import com.grupocordillera.finanzas_service.model.MetodoPago;
import com.grupocordillera.finanzas_service.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository repository;

    public List<MetodoPago> getMetodos() {
        return repository.findAll();
    }

    public Optional<MetodoPago> getMetodo(Integer id) {
        return repository.findById(id);
    }

    public MetodoPago saveMetodo(MetodoPago metodo) {
        return repository.save(metodo);
    }

    public MetodoPago updateMetodo(Integer id, MetodoPago metodo) {
        if (!repository.existsById(id))
            throw new RuntimeException("Método de pago no encontrado con id: " + id);
        metodo.setId(id);
        return repository.save(metodo);
    }

    public void deleteMetodo(Integer id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Método de pago no encontrado con id: " + id);
        repository.deleteById(id);
    }

    public List<MetodoPago> getMetodosActivos() {
        return repository.findMetodosActivos();
    }
}
