package com.grupocordillera.reportes_service.repository;

import com.grupocordillera.reportes_service.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
}
