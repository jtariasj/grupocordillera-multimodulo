package com.grupocordillera.finanzas_service.service;

import com.grupocordillera.finanzas_service.model.MovimientoContable;
import com.grupocordillera.finanzas_service.repository.MovimientoContableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoContableService {

    @Autowired
    private MovimientoContableRepository repository;

    public List<MovimientoContable> getMovimientos() {
        return repository.findAll();
    }

    public Optional<MovimientoContable> getMovimiento(Integer id) {
        return repository.findById(id);
    }

    public MovimientoContable saveMovimiento(MovimientoContable movimiento) {
        return repository.save(movimiento);
    }

    public MovimientoContable updateMovimiento(Integer id, MovimientoContable movimiento) {
        if (!repository.existsById(id))
            throw new RuntimeException("Movimiento no encontrado con id: " + id);
        movimiento.setId(id);
        return repository.save(movimiento);
    }

    public void deleteMovimiento(Integer id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Movimiento no encontrado con id: " + id);
        repository.deleteById(id);
    }

    public List<MovimientoContable> getIngresos() { return repository.findIngresos(); }
    public List<MovimientoContable> getEgresos()  { return repository.findEgresos(); }
    public List<MovimientoContable> getActivos()  { return repository.findMovimientosActivos(); }
}
