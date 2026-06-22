package com.grupocordillera.seguridad_service.repository;

import com.grupocordillera.seguridad_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
