package com.grupocordillera.descuentos_service.service;

import com.grupocordillera.descuentos_service.model.CampanaDescuento;
import com.grupocordillera.descuentos_service.repository.CampanaDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampanaDescuentoService {

    @Autowired
    private CampanaDescuentoRepository repository;

    public List<CampanaDescuento> getCampanas() {
        return repository.findAll();
    }

    public Optional<CampanaDescuento> getCampana(Integer id) {
        return repository.findById(id);
    }

    public CampanaDescuento saveCampana(CampanaDescuento campana) {
        return repository.save(campana);
    }

    public CampanaDescuento updateCampana(Integer id, CampanaDescuento campana) {
        Optional<CampanaDescuento> existe = getCampana(id);
        if (existe.isEmpty())
            throw new RuntimeException("Campaña no encontrada con id: " + id);
        campana.setIdCampana(id);
        return repository.save(campana);
    }

    public void deleteCampana(Integer id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("Campaña no encontrada con id: " + id);
    }

    public List<CampanaDescuento> getCampanasActivas() {
        return repository.findCampanasActivas();
    }

    public List<CampanaDescuento> getCampanasByCanal(CampanaDescuento.Canal canal) {
        return repository.findByCanal(canal);
    }
}
