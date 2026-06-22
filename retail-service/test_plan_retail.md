# Plan de pruebas Microservicio de Retail GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de las clases Sucursal y Empleado

## Herramientas

* JUnit

## Caso de prueba

### ReP-01

Crear sucursal con datos validos

### Objetivo

Verificar que la sucursal no contenga
campos nulos.

## Resultado esperado
* La sucursal contiene nombre y descripcion no nulos
* La lista de empleados existe y esta vacia al momento de creacion

---

### ReP-02

Crear empleado con datos validos

### Objetivo

Verificar que el empleado
pueda crearse correctamente.

## Resultado esperado
* Todos los campos no son nulos
* El empleado tiene una sucursal asignada

---

### ReP-03

Verificacion de la existencia de una lista con empleados

### Objetivo

Verificar que una empleado puede relacionarse
a una sucursal.

## Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un empleado
* La lista de empleados es asignada a la sucursal

---

### ReP-04

Verificar tiempo entre periodos correctos

### Objetivo

Verificar que la fecha del contrato
sea luego de la fecha de nacimiento.

## Resultado esperado
* La fecha del contrato ocurre despues de la del nacimiento

---

### ReP-05

Eliminar un empleado de sucursal

### Objetivo

Verificar que un empleado es eliminado
de una sucursal.

## Resultado esperado
* La lista ya no contiene al empleado
* La lista queda vacia pero no nula

---