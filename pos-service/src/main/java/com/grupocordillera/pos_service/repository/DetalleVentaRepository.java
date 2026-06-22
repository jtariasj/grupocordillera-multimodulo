package com.grupocordillera.pos_service.repository;

import com.grupocordillera.pos_service.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {

    @Query("SELECT d FROM DetalleVenta d WHERE d.ventaFisica.id = :idVenta")
    List<DetalleVenta> findByVentaId(@Param("idVenta") Integer idVenta);
}
