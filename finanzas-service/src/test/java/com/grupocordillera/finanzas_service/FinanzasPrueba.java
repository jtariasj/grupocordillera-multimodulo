package com.grupocordillera.finanzas_service;

import com.grupocordillera.finanzas_service.model.MetodoPago;
import com.grupocordillera.finanzas_service.model.MovimientoContable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class FinanzasPrueba {
    private MetodoPago metodoPago;
    private MovimientoContable movimiento;

    @BeforeEach
    public void setUp() {
        metodoPago = new MetodoPago(
                null,
                "Tarjeta de Débito",
                MetodoPago.TipoPago.TARJETA_DEBITO,
                null,
                true
        );

        movimiento = new MovimientoContable(
                null,
                MovimientoContable.TipoMovimiento.INGRESO,
                MovimientoContable.OrigenMovimiento.VENTA_FISICA,
                15000.0,
                "Venta en sucursal centro",
                LocalDateTime.of(2025, Month.JANUARY, 10, 14, 30),
                metodoPago,
                true
        );
    }

    @Test
    @DisplayName("FP-01 - Verificar que un método de pago pueda crearse correctamente")
    public void crearMetodoPago() {
        assertNotNull(metodoPago.getNombre());
        assertFalse(metodoPago.getNombre().isBlank());
        assertNotNull(metodoPago.getTipo());

    }

    @Test
    @DisplayName("FP-02 - Verificar que un movimiento contable pueda crearse correctamente")
    public void crearMovimientoContable() {
        assertNotNull(movimiento.getTipo());
        assertNotNull(movimiento.getOrigen());
        assertTrue(movimiento.getMonto() > 0);
        assertNotNull(movimiento.getMetodoPago());
    }


    @Test
    @DisplayName("FP-03 - Verificar que el movimiento tenga un método de pago asignado")
    public void movimientoTieneMetodoPago() {
        assertNotNull(movimiento.getMetodoPago());
        assertNotNull(movimiento.getMetodoPago().getNombre());
        assertFalse(movimiento.getMetodoPago().getNombre().isBlank());
    }

} //En teoria los movimientos no deben ser eliminados para mantener el registro
