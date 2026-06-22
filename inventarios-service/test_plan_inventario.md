# Plan de pruebas Microservicio de Inventario GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de las clases Producto y CategoriaProducto

## Herramientas

* JUnit

## Caso de prueba

### IP-01

Crear categoria con datos validos

### Objetivo

Verificar que la categoria pueda crearse
correctamente.

## Resultado esperado
* El nombre de la categoria no esta vacia y no es null
* La lista de productos existe y esta vacia al momento de creacion

---

### IP-02

Crear producto con datos validos

### Objetivo

Verificar que un producto puede crearse
correctamente.

## Resultado esperado
* El Sku no es null ni vacio
* El nombre no es null
* El precio es mayor a cero
* El modelo no es null

---

### IP-03

Verificacion de la existencia de una lista con productos

### Objetivo

Verificar que un producto puede relacionarse
a una categoria.

## Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un producto
* La lista de productos es asignada a la categoria

---

### IP-04

Eliminar producto de categoria

### Objetivo

Verificar que un producto puede
desvincularse de una categoria.

## Resultado esperado
* La lista ya no contiene al producto
* La lista queda vacia pero no null

---

