package com.grupocordillera.retail_service.repository;

import com.grupocordillera.retail_service.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
