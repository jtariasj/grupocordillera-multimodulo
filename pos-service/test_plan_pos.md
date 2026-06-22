# Plan de pruebas Microservicio de POS GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de las clases VentaFisica y DetalleVenta

## Herramientas

* JUnit

## Caso de prueba

### PP-01

Crear venta con datos validos

### Objetivo

Verificar que la venta no contenga
campos nulos.

## Resultado esperado
* El numero de la boleta no es null ni vacío
* El total debe ser mayor a cero
* El estado es "PENDIENTE" por defecto
* La lista de detalles existe y está vacía
---

### PP-02

Crear detalle de venta con datos validos

### Objetivo

Verificar que el detalle de las ventas
pueda crearse correctamente.

## Resultado esperado
* El nombre del producto no es null
* La cantidad de productos es mayor a cero
* El precio unitario del producto es mayor a cero

---

### PP-03

Calcular subtotal de los productos

### Objetivo
Verificar que el subtotal sea igual a cantidad*precio - descuento.

## Resultado esperado:
* El subtotal es correctamente calculado

---

### PP-04

Agregar detalles a la venta

### Objetivo

Verificar que la venta tenga detalles de productos.

## Resultado esperado
* La lista contiene detalles de productos
* La lista tiene al menos un producto con sus detalles
* A la venta se le asigna la lista con los productos

---