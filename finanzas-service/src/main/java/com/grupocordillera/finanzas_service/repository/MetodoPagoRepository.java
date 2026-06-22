package com.grupocordillera.finanzas_service.repository;

import com.grupocordillera.finanzas_service.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

    @Query("SELECT m FROM MetodoPago m WHERE m.activo = TRUE")
    List<MetodoPago> findMetodosActivos();
}
