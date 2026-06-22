package com.grupocordillera.ecommerce_service;

import com.grupocordillera.ecommerce_service.model.ClienteDigital;
import com.grupocordillera.ecommerce_service.model.PedidoOnline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EcommercePrueba {
    private ClienteDigital cliente;
    private PedidoOnline pedido;

    @BeforeEach
    public void setUp() {
        cliente = new ClienteDigital(
                null,
                "María",
                "González",
                "maria.gonzalez@mail.com",
                "+56987654321",
                "Av. Siempre Viva 123",
                LocalDateTime.of(2024, Month.JANUARY, 10, 9, 0),
                LocalDateTime.of(2025, Month.MARCH, 5, 14, 30),
                true,
                new ArrayList<>()
        );

        pedido = new PedidoOnline(
                null,
                "00123",
                cliente,
                LocalDateTime.of(2025, Month.MARCH, 5, 15, 0),
                "Av. Siempre Viva 123",
                25990.0,
                PedidoOnline.EstadoPedido.PENDIENTE,
                true
        );
    }

    @Test
    @DisplayName("EP-01 - Verificar que un cliente digital pueda crearse correctamente")
    public void crearClienteDigital() {
        assertNotNull(cliente.getNombre());
        assertNotNull(cliente.getApellido());
        assertFalse(cliente.getNombre().isBlank());
        assertFalse(cliente.getApellido().isBlank());
        assertNotNull(cliente.getEmail());
        assertFalse(cliente.getEmail().isBlank());
        assertNotNull(cliente.getPedidos());
        assertTrue(cliente.getPedidos().isEmpty());
    }

    @Test
    @DisplayName("EP-02 - Verificar que un pedido online pueda crearse correctamente")
    public void crearPedidoOnline() {
        assertNotNull(pedido.getNumeroPedido());
        assertFalse(pedido.getNumeroPedido().isBlank());
        assertNotNull(pedido.getCliente());
        assertNotNull(pedido.getDireccionEntrega());
        assertFalse(pedido.getDireccionEntrega().isBlank());
        assertTrue(pedido.getTotal() > 0);
        assertEquals(PedidoOnline.EstadoPedido.PENDIENTE, pedido.getEstado());

    }

    @Test
    @DisplayName("EP-03 - Verificar que un pedido pueda asociarse a un cliente")
    public void agregarPedidoACliente() {
        cliente.getPedidos().add(pedido);

        assertEquals(1, cliente.getPedidos().size());
        assertTrue(cliente.getPedidos().contains(pedido));
    }


    @Test
    @DisplayName("EP-04 - Verificar que un pedido pueda eliminarse de un cliente")
    public void eliminarPedidoDeCliente() {
        cliente.getPedidos().add(pedido);
        cliente.getPedidos().remove(pedido);

        assertFalse(cliente.getPedidos().contains(pedido));
        assertNotNull(cliente.getPedidos());
        assertTrue(cliente.getPedidos().isEmpty());
    }
}

