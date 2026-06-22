package com.grupocordillera.retail_service;

import com.grupocordillera.retail_service.model.Empleado;
import com.grupocordillera.retail_service.model.Sucursal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;


public class RetailPrueba {
    private Sucursal sucursal;
    private Empleado empleado;

    @BeforeEach
    public void setUp(){
        sucursal = new Sucursal(null,"Puente Alto", "Av. San Carlos",true,new ArrayList<>());
        empleado = new Empleado(null,sucursal,"12345678","9","Bob","Esponja","Pantalones Cuadrados","spsq@mail.com","+56912345678",LocalDate.of(1990, 5, 15),LocalDate.of(2015, 3, 1),"Vendedor",true);
    }


    @DisplayName("ReP-01 - Verificar que una sucursal pueda crearse correctamente")
    @Test
    public void crearSucursal() {
        assertNotNull(sucursal.getNombre());
        assertNotNull(sucursal.getDireccion());
        assertTrue(sucursal.getActivo());
        assertNotNull(sucursal.getEmpleados());
        assertTrue(sucursal.getEmpleados().isEmpty());
    }

    @DisplayName("ReP-02 - Verificar que un empleado pueda crearse correctamente")
    @Test
    public void crearEmpleado() {
        assertNotNull(empleado.getRun());
        assertNotNull(empleado.getNombre());
        assertNotNull(empleado.getApellidoPaterno());
        assertNotNull(empleado.getCorreo());
        assertNotNull(empleado.getSucursal());
        assertTrue(empleado.getActivo());
    }

    @DisplayName("ReP-03 - Verificar que un empleado pueda asociarse a una sucursal")
    @Test
    public void sucursalConEmpleados() {
        sucursal.getEmpleados().add(empleado);

        assertEquals(1, sucursal.getEmpleados().size());
        assertTrue(sucursal.getEmpleados().contains(empleado));
    }


    @DisplayName("ReP-04 - Verificar que la fecha de contrato sea luego a la fecha de nacimiento")
    @Test
    public void fechaContratoValida() {
        assertTrue(empleado.getFechaContrato().isAfter(empleado.getFechaNacimiento()));
    }


    @DisplayName("ReP-05 - Verificar que un empleado pueda eliminarse de la sucursal")
    @Test
    public void eliminarEmpleadoDeSucursal() {
        sucursal.getEmpleados().add(empleado);
        sucursal.getEmpleados().remove(empleado);

        assertFalse(sucursal.getEmpleados().contains(empleado));
        assertNotNull(sucursal.getEmpleados());
        assertTrue(sucursal.getEmpleados().isEmpty());
    }

}
