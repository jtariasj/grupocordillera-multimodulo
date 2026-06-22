package com.grupocordillera.pos_service.repository;

import com.grupocordillera.pos_service.model.VentaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VentaFisicaRepository extends JpaRepository<VentaFisica, Integer> {

    @Query("SELECT v FROM VentaFisica v WHERE v.activo = TRUE")
    List<VentaFisica> findVentasActivas();

    @Query("SELECT v FROM VentaFisica v WHERE v.estado = 'COMPLETADA'")
    List<VentaFisica> findVentasCompletadas();
}
