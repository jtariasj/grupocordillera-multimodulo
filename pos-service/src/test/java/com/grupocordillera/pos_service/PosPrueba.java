package com.grupocordillera.pos_service;

import com.grupocordillera.pos_service.model.DetalleVenta;
import com.grupocordillera.pos_service.model.VentaFisica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PosPrueba {
    private VentaFisica venta;
    private DetalleVenta detalle;

    @BeforeEach
    public void setUp() {
        venta = new VentaFisica(
                null,
                "B1232",
                LocalDateTime.of(2025, Month.JANUARY, 10, 14, 30),
                1325000.0,
                VentaFisica.EstadoVenta.PENDIENTE,
                true,
                new ArrayList<>()
        );

        detalle = new DetalleVenta(
                null,
                venta,
                "Play 5",
                3,
                500000.0,
                1325000.0,
                175000.0,
                true
        );
    }

    @DisplayName("PP-01 - Verificar que una venta no contenga datos nulos")
    @Test
    public void crearVentaFisica() {
        assertNotNull(venta.getNumeroBoleta()); //El numero de boleta no es null
        assertFalse(venta.getNumeroBoleta().isBlank()); //El numero de boleta no esta vacio
        assertTrue(venta.getTotal()>0);
        assertEquals(VentaFisica.EstadoVenta.PENDIENTE, venta.getEstado()); //Verifica si esta pendiente por default
        assertNotNull(venta.getDetalles());
        assertTrue(venta.getDetalles().isEmpty());
    }

    @DisplayName("PP-02 - Verificar que los detalle de las ventas puedan crearse correctamente")
    @Test
    public void crearDetalleVenta() {
        assertNotNull(detalle.getNombreProducto());
        assertTrue(detalle.getCantidad() > 0);
        assertTrue(detalle.getPrecioUnitario() > 0);
    }


    @DisplayName("PO-03 - Calcular el subtotal")
    @Test
    public void calcularSubtotal() {
        double esperado = detalle.getCantidad() * detalle.getPrecioUnitario() - detalle.getDescuento();
        assertEquals(esperado, detalle.getSubtotal());
    }

    @DisplayName("PP-04 - Verificar que un detalle pueda agregarse a una venta")
    @Test
    public void agregarDetalleAVenta() {
        venta.getDetalles().add(detalle);

        assertEquals(1, venta.getDetalles().size());
        assertTrue(venta.getDetalles().contains(detalle));
    }
}
