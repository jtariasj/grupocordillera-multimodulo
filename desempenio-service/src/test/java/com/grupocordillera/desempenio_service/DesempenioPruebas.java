package com.grupocordillera.desempenio_service;

import com.grupocordillera.desempenio_service.model.Metrica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesempenioPruebas {

    private Metrica metrica;

    @BeforeEach
    public void setUp() {
        metrica = new Metrica(
                null,
                "Ventas Mensuales",
                85000.0,
                100000.0,
                "$",
                null // ultimaActualizacion la maneja @UpdateTimestamp
        );
    }

    @Test
    @DisplayName("DeP-01 - Verificar que una métrica pueda crearse correctamente")
    public void crearMetrica() {
        assertNotNull(metrica.getNombre());
        assertFalse(metrica.getNombre().isBlank());
        assertNotNull(metrica.getUnidadMedida());
        assertTrue(metrica.getValorActual() >= 0);
        assertTrue(metrica.getMetaObjetivo() >= 0);
    }

    @Test
    @DisplayName("DeP-02 - Verificar que la métrica alcanza su objetivo")
    public void metricaAlcanzaObjetivo() {
        metrica.setValorActual(100000.0);
        assertTrue(metrica.getValorActual() >= metrica.getMetaObjetivo());
    }

    @Test
    @DisplayName("DeP-03 - Verificar que la métrica no ha alcanzado su objetivo")
    public void metricaNoAlcanzaObjetivo() {
        assertTrue(metrica.getValorActual() < metrica.getMetaObjetivo());
    }
}
