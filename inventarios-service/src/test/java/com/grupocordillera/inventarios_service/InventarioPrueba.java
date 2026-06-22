package com.grupocordillera.inventarios_service;

import com.grupocordillera.inventarios_service.model.CategoriaProducto;
import com.grupocordillera.inventarios_service.model.Producto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InventarioPrueba {
/*
    @Test
    void registrarProducto(){

        Faker faker = new Faker();
        Producto producto = new Producto();

        producto.setNombre("Lavadora");
        producto.setDescripcion(faker.lorem().sentence());
        producto.setSku("ASBD252275211");   //13 caracteres
        producto.setPrecio(129900);

        System.out.println(producto);

        assertNotNull(producto);
        assertNotEquals("", producto.getNombre());
        assertNotNull(producto.getNombre());
        assertEquals(12, producto.getSku().length());

    }
 */

    private Producto producto;
    private CategoriaProducto categoria;

    @BeforeEach
    public void setUp() {
        categoria = new CategoriaProducto(
                null,
                "Electrónica",
                new ArrayList<>()
        );

        producto = new Producto(
                null,
                categoria,
                "ASBD252275211",
                "Lavadora",
                "Lavadora y secadora",
                129900,
                "SamsungWashingMachine-39",
                true
        );
    }

    @DisplayName("IP-01 - Verificar que una categoría pueda crearse correctamente")
    @Test
    public void crearCategoria() {
        assertNotNull(categoria.getNombre());
        assertFalse(categoria.getNombre().isBlank());
        assertNotNull(categoria.getProductos());
        assertTrue(categoria.getProductos().isEmpty());
    }

    @DisplayName("IP-02 - Verificar que un producto pueda crearse correctamente")
    @Test
    public void crearProducto() {
        assertNotNull(producto.getSku());
        assertFalse(producto.getSku().isBlank());
        assertNotNull(producto.getNombre());
        assertTrue(producto.getPrecio() > 0);
        assertNotNull(producto.getModelo());

    }

    @DisplayName("IP-03 - Verificar que un producto pueda asociarse a una categoria")
    @Test
    public void agregarProductoCategoria() {
        categoria.getProductos().add(producto);

        assertEquals(1, categoria.getProductos().size());
        assertTrue(categoria.getProductos().contains(producto));
    }

    @DisplayName("IP-04 - Verificar que un producto pueda eliminarse de una categoria")
    @Test
    public void eliminarProductoDeCategoria() {
        categoria.getProductos().add(producto);
        categoria.getProductos().remove(producto);

        assertFalse(categoria.getProductos().contains(producto));
        assertNotNull(categoria.getProductos());
        assertTrue(categoria.getProductos().isEmpty());
    }
}
