package com.grupocordillera.ecommerce_service.service;

import com.grupocordillera.ecommerce_service.client.MetodoPagoClient;
import com.grupocordillera.ecommerce_service.dto.MetodoPagoDTO;
import com.grupocordillera.ecommerce_service.dto.PedidoMetodoPagoDTO;
import com.grupocordillera.ecommerce_service.model.PedidoOnline;
import com.grupocordillera.ecommerce_service.repository.PedidoOnlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoOnlineService {

    @Autowired
    private PedidoOnlineRepository repository;

    public List<PedidoOnline> getPedidos() {
        return repository.findAll();
    }

    public Optional<PedidoOnline> getPedido(Integer id) {
        return repository.findById(id);
    }

    public PedidoOnline savePedido(PedidoOnline pedido) {
        return repository.save(pedido);
    }

    public PedidoOnline updatePedido(Integer id, PedidoOnline pedido) {
        if (!repository.existsById(id))
            throw new RuntimeException("Pedido no encontrado con id: " + id);
        pedido.setId(id);
        return repository.save(pedido);
    }

    public void deletePedido(Integer id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Pedido no encontrado con id: " + id);
        repository.deleteById(id);
    }

    public List<PedidoOnline> getPedidosPendientes() {
        return repository.findPedidosPendientes();
    }

    @Autowired
    private MetodoPagoClient metodoPagoClient;

    public PedidoMetodoPagoDTO getPedidoConMetodo(Integer idPedido, Integer idMetodo) {


        PedidoOnline pedido =
                repository.findById(idPedido).orElse(null);

        MetodoPagoDTO metodoPago =
                metodoPagoClient.obtenerMetodoPago(idMetodo);

        PedidoMetodoPagoDTO dto =
                new PedidoMetodoPagoDTO();

        dto.setIdPedido(pedido.getId());
        dto.setId_cliente(pedido.getCliente().getId());
        dto.setNumeroPedido(pedido.getNumeroPedido());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setMetodoPago(metodoPago);
        dto.setTotal(pedido.getTotal());

        return dto;
    }
}
