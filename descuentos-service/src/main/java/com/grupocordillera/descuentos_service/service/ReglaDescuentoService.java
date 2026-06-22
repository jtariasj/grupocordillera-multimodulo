package com.grupocordillera.descuentos_service.service;

import com.grupocordillera.descuentos_service.model.ReglaDescuento;
import com.grupocordillera.descuentos_service.repository.ReglaDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReglaDescuentoService {

    @Autowired
    private ReglaDescuentoRepository repository;

    public List<ReglaDescuento> getReglas() {
        return repository.findAll();
    }

    public Optional<ReglaDescuento> getRegla(Integer id) {
        return repository.findById(id);
    }

    public ReglaDescuento saveRegla(ReglaDescuento regla) {
        return repository.save(regla);
    }

    public ReglaDescuento updateRegla(Integer id, ReglaDescuento regla) {
        Optional<ReglaDescuento> existe = getRegla(id);
        if (existe.isEmpty())
            throw new RuntimeException("Regla no encontrada con id: " + id);
        regla.setIdRegla(id);
        return repository.save(regla);
    }

    public void deleteRegla(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("Regla no encontrada con id: " + id);
    }

    public List<ReglaDescuento> getReglasByCampana(Integer idCampana) {
        return repository.findByCampanaId(idCampana);
    }

    public List<ReglaDescuento> getReglasActivasOrdenadas() {
        return repository.findReglasActivasOrdenadas();
    }
}
