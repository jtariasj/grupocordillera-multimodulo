package com.grupocordillera.descuentos_service;

import com.grupocordillera.descuentos_service.model.CampanaDescuento;
import com.grupocordillera.descuentos_service.model.Cupon;
import com.grupocordillera.descuentos_service.model.ReglaDescuento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DescuentosPrueba {
    private CampanaDescuento campana;
    private Cupon cupon;
    private ReglaDescuento regla;

    @BeforeEach
    public void setUp() {
        campana = new CampanaDescuento(
                null,
                "Campaña Verano 2025",
                "Descuentos especiales de verano",
                LocalDate.of(2025, Month.JANUARY, 1),
                LocalDate.of(2025, Month.MARCH, 31),
                CampanaDescuento.TipoDescuento.PORCENTAJE,
                15.0,
                500000.0,
                CampanaDescuento.Canal.AMBOS,
                true,
                new ArrayList<>(),
                new ArrayList<>()
        );

        cupon = new Cupon(
                null,
                campana,
                "VERANO15",
                "Cupón 15% de descuento",
                5,
                0,
                LocalDate.of(2025, Month.MARCH, 31),
                5.0,
                false,
                true
        );

        regla = new ReglaDescuento(
                null,
                campana,
                "Monto mínimo",
                "Aplica con compras sobre $50.000",
                ReglaDescuento.Condicion.MONTO_MINIMO,
                "50000",
                1,
                false,
                true
        );
    }

    @Test
    @DisplayName("DS-01 - Verificar que una campaña pueda crearse correctamente")
    public void crearCampana() {
        assertNotNull(campana.getNombre());
        assertFalse(campana.getNombre().isBlank());
        assertNotNull(campana.getDescripcion());
        assertTrue(campana.getValorDescuento() > 0);
        assertTrue(campana.getPresupuestoMaximo() > 0);
        assertTrue(campana.getActivo());
        assertNotNull(campana.getReglas());
        assertTrue(campana.getReglas().isEmpty());
        assertNotNull(campana.getCupones());
        assertTrue(campana.getCupones().isEmpty());
    }

    @Test
    @DisplayName("DS-02 - Verificar que fechaFin no sea anterior a fechaInicio")
    public void fechasCampanaCoherentes() {
        assertTrue(campana.getFechaFin().isAfter(campana.getFechaInicio()) ||
                campana.getFechaFin().isEqual(campana.getFechaInicio()));
    }

    @Test
    @DisplayName("DS-03 - Verificar que un cupón pueda crearse correctamente")
    public void crearCupon() {
        assertNotNull(cupon.getCodigo());
        assertFalse(cupon.getCodigo().isBlank());
        assertEquals(0, cupon.getUsosActuales());
        assertTrue(cupon.getUsosMaximos() > 0);
        assertTrue(cupon.getActivo());
    }

    @Test
    @DisplayName("DS-04 - Verificar que el cupón tenga usos disponibles")
    public void cuponTieneUsosDisponibles() {
        assertTrue(cupon.getUsosActuales() < cupon.getUsosMaximos());
    }

    @Test
    @DisplayName("DS-05 - Verificar que una regla pueda crearse correctamente")
    public void crearReglaDescuento() {
        assertNotNull(regla.getNombreRegla());
        assertFalse(regla.getNombreRegla().isBlank());
        assertNotNull(regla.getCondicion());
        assertTrue(regla.getPrioridad() > 0);
        assertFalse(regla.getAcumulable());
    }
}
