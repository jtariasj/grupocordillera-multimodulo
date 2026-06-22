# Plan de pruebas Microservicio de E-Commerce GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de las clases Producto online y Cliente digital

## Herramientas

* JUnit

## Caso de prueba

### EP-01

Crear cliente con datos validos

### Objetivo

Verificar que el cliente pueda crearse
correctamente.

## Resultado esperado
* El nombre y apellido del cliente no esta vacio y no es null
* El email no es null ni vacio
* El pedido con la lista de productos existe y esta vacia

---

### EP-02

Crear pedido con datos validos

### Objetivo

Verificar que un pedido puede crearse
correctamente.

## Resultado esperado
* El numero del pedido no es null ni vacio
* El cliente no es null
* La direccion de entrega no es null ni vacio
* El total es mayor a cero
* El estado es "PENDIENTE" por defecto


---

### EP-03

Agregar pedido a cliente

### Objetivo

Verificar que el pedido con productos
puede asociarse con un cliente.


## Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un producto
* La lista de productos es asignada a la categoria

---

### EP-04

Eliminar pedidos de cliente

### Objetivo

Verificar que un pedido puede
desvincularse de un cliente.

## Resultado esperado
* La lista ya no contiene al pedido
* La lista queda vacia pero no null

---

