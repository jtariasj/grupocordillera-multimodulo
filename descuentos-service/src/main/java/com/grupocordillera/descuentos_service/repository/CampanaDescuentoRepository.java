package com.grupocordillera.descuentos_service.repository;

import com.grupocordillera.descuentos_service.model.CampanaDescuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampanaDescuentoRepository extends JpaRepository<CampanaDescuento, Integer> {

    @Query("SELECT c FROM CampanaDescuento c WHERE c.activo = TRUE")
    List<CampanaDescuento> findCampanasActivas();

    @Query("SELECT c FROM CampanaDescuento c WHERE c.canal = :canal AND c.activo = TRUE")
    List<CampanaDescuento> findByCanal(CampanaDescuento.Canal canal);
}
