package com.grupocordillera.descuentos_service.repository;

import com.grupocordillera.descuentos_service.model.ReglaDescuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReglaDescuentoRepository extends JpaRepository<ReglaDescuento, Integer> {

    @Query("SELECT r FROM ReglaDescuento r WHERE r.campana.idCampana = :idCampana")
    List<ReglaDescuento> findByCampanaId(@Param("idCampana") Integer idCampana);

    @Query("SELECT r FROM ReglaDescuento r WHERE r.activo = TRUE ORDER BY r.prioridad ASC")
    List<ReglaDescuento> findReglasActivasOrdenadas();
}
