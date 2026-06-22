package com.grupocordillera.finanzas_service.repository;

import com.grupocordillera.finanzas_service.model.MovimientoContable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MovimientoContableRepository extends JpaRepository<MovimientoContable, Integer> {

    @Query("SELECT m FROM MovimientoContable m WHERE m.tipo = 'INGRESO'")
    List<MovimientoContable> findIngresos();

    @Query("SELECT m FROM MovimientoContable m WHERE m.tipo = 'EGRESO'")
    List<MovimientoContable> findEgresos();

    @Query("SELECT m FROM MovimientoContable m WHERE m.activo = TRUE")
    List<MovimientoContable> findMovimientosActivos();
}
