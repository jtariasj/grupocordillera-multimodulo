package com.grupocordillera.reportes_service;

import com.grupocordillera.reportes_service.model.Reporte;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReportesPrueba {

    @DisplayName("RP-01 Verificar que un reporte pueda crearse correctamente.")
    @Test
    public void crearReporte() {
        Reporte reporte = new Reporte(null,"Titulo de prueba","Ventas",null, 1,"Procesando");
        assertNotNull(reporte.getTitulo());
        assertNotNull(reporte.getTipoReporte());
        assertNotNull(reporte.getEstadoReporte());
    }
}
