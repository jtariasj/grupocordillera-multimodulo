package com.grupocordillera.seguridad_service;


import com.grupocordillera.seguridad_service.model.Roles;
import com.grupocordillera.seguridad_service.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeguridadPrueba {

    private Roles rol;
    private Usuario usuario;

    //Antes de hacer cada prueba se corre esta funcion y crea un rol desde el inicio
    //Idea sacada de "PRUEBAS UNITARIAS en JAVA (JUNIT 5) - Tutorial Completo Facil" de Programando en JAVA
    //https://youtu.be/74sClDEYSQ4?si=kTGbw1tSzm9HA4QI&t=579

    @BeforeEach
    public void setUp() {
        rol = new Roles();
        rol.setNombre("ADMIN");
        rol.setDescripcion("Administrador del sistema");

        //los campos de idUsuario y ultimoacceso son utilizados
        //al momento de "manejar datos reales" no son necesarios en las pruebas
        Usuario usuario = new Usuario(null, "jaimencio", "contraseña", "jaimencio@mail.com", null, rol);
    }

    @DisplayName("Funcion de prueba")
    @Test
    public void revisarLista(){
        assertNotNull(rol.getUsuario());
        assertTrue(rol.getUsuario().isEmpty());

    }
    @DisplayName("SP-01 Verificar que un rol pueda crearse correctamente.")
    @Test
    public void crearRol(){
        assertNotNull(rol.getNombre());
        assertNotNull(rol.getDescripcion());
    }

    @DisplayName("SP-02 Verificacion del registro de un usuario")
    @Test
    public void crearUsuario() {
        assertNotNull(usuario.getUsername());
        assertNotNull(usuario.getEmail());
        assertNotNull(usuario.getRol());
        assertFalse(usuario.getUsername().isBlank());
        assertFalse(usuario.getEmail().isBlank());
    }

    @DisplayName("SP-03 - Verificar que un usuario pueda ser agregado al rol")
    @Test
    public void agregarUsuarioAlRol() {

        rol.getUsuario().add(usuario);

        assertEquals(1, rol.getUsuario().size());
        assertTrue(rol.getUsuario().contains(usuario));
    }
    @DisplayName("SP-04 - Verificar que un usuario pueda ser eliminado del rol")
    @Test
    public void eliminarUsuarioDelRol() {

        rol.getUsuario().add(usuario); //Añadir un usuario
        rol.getUsuario().remove(usuario); //Eliminar un usuario

        assertFalse(rol.getUsuario().contains(usuario)); //Ver si la no lista contiene al usuario
        assertNotNull(rol.getUsuario()); //Ver que no contiene usuarios
        assertTrue(rol.getUsuario().isEmpty()); //Ver que la lista esta vacia
    }
}
