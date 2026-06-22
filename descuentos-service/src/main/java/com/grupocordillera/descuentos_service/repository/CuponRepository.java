package com.grupocordillera.descuentos_service.repository;

import com.grupocordillera.descuentos_service.model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CuponRepository extends JpaRepository<Cupon, Integer> {

    Optional<Cupon> findByCodigo(String codigo);

    @Query("SELECT c FROM Cupon c WHERE c.activo = TRUE AND c.usosActuales < c.usosMaximos")
    List<Cupon> findCuponesDisponibles();

    @Query(value = "SELECT * FROM cupones WHERE fecha_expiracion >= CURDATE() AND activo = true", nativeQuery = true)
    List<Cupon> findCuponesVigentes();

    @Query("SELECT c FROM Cupon c WHERE c.campana.idCampana = :idCampana")
    List<Cupon> findByCampanaId(@Param("idCampana") Integer idCampana);
}
