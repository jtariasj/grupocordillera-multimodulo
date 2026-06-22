package com.grupocordillera.seguridad_service.service;

import com.grupocordillera.seguridad_service.model.Roles;
import com.grupocordillera.seguridad_service.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository repository;

    public List<Roles> getRoles() {
        return repository.findAll();
    }

    public Optional<Roles> getRol(Integer id) {
        return repository.findById(id);
    }

    public Roles saveRol(Roles rol) {
        return repository.save(rol);
    }

    public Roles updateRol(Integer id, Roles rol) {
        Optional<Roles> existe = getRol(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("Rol no encontrado");
        } else {
            rol.setIdRol(id); // aseguramos que se actualice el correcto
            return repository.save(rol);
        }
    }

    public void deleteRol(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Rol no encontrado");
        }
    }
}
