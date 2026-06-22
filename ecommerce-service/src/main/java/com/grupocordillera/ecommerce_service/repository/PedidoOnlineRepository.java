package com.grupocordillera.ecommerce_service.repository;

import com.grupocordillera.ecommerce_service.model.PedidoOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PedidoOnlineRepository extends JpaRepository<PedidoOnline, Integer> {

    @Query("SELECT p FROM PedidoOnline p WHERE p.cliente.id = :idCliente")
    List<PedidoOnline> findByClienteId(@Param("idCliente") Integer idCliente);

    @Query("SELECT p FROM PedidoOnline p WHERE p.estado = 'PENDIENTE'")
    List<PedidoOnline> findPedidosPendientes();
}
