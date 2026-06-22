package com.grupocordillera.ecommerce_service.repository;

import com.grupocordillera.ecommerce_service.model.ClienteDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface ClienteDigitalRepository extends JpaRepository<ClienteDigital, Integer> {

    Optional<ClienteDigital> findByEmail(String email);

    @Query("SELECT c FROM ClienteDigital c WHERE c.activo = TRUE")
    List<ClienteDigital> findClientesActivos();
}
