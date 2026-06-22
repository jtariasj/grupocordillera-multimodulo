package com.grupocordillera.descuentos_service.service;

import com.grupocordillera.descuentos_service.model.Cupon;
import com.grupocordillera.descuentos_service.repository.CuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuponService {

    @Autowired
    private CuponRepository repository;

    public List<Cupon> getCupones() {
        return repository.findAll();
    }

    public Optional<Cupon> getCupon(Integer id) {
        return repository.findById(id);
    }

    public Optional<Cupon> getCuponByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    public Cupon saveCupon(Cupon cupon) {
        return repository.save(cupon);
    }

    public Cupon updateCupon(Integer id, Cupon cupon) {
        Optional<Cupon> existe = getCupon(id);
        if (existe.isEmpty())
            throw new RuntimeException("Cupón no encontrado con id: " + id);
        cupon.setIdCupon(id);
        return repository.save(cupon);
    }

    public void deleteCupon(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("Cupón no encontrado con id: " + id);
    }

    public List<Cupon> getCuponesDisponibles() {
        return repository.findCuponesDisponibles();
    }

    public List<Cupon> getCuponesVigentes() {
        return repository.findCuponesVigentes();
    }
}
