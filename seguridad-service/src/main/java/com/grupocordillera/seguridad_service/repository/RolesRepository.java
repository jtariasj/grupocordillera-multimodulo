package com.grupocordillera.seguridad_service.repository;

import com.grupocordillera.seguridad_service.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
}
