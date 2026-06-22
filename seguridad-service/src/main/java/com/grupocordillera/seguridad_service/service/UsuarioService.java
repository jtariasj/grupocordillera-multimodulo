package com.grupocordillera.seguridad_service.service;

import com.grupocordillera.seguridad_service.model.Usuario;
import com.grupocordillera.seguridad_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }

    public Optional<Usuario> getUsuario(Integer id) {
        return repository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Optional<Usuario> existe = getUsuario(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        } else {
            usuario.setIdUsuario(id); // aseguramos que se actualice el correcto
            return repository.save(usuario);
        }
    }

    public void deleteUsuario(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }
}
