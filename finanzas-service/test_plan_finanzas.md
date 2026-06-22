# Plan de pruebas Microservicio de Finanzas GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de las clases Metodo de pago y Movimiento contable

## Herramientas

* JUnit

## Caso de prueba

### FP-01

Crear metodo de pago con datos validos

### Objetivo

Verificar que un metodo de pago pueda crearse
correctamente.

## Resultado esperado
* El nombre de la categoria no esta vacia y no es null
* El tipo no es null
* La lista de productos existe y esta vacia al momento de creacion

---

### FP-02

Crear movimientos con datos validos

### Objetivo

Verificar que un movimiento puede crearse
correctamente.

## Resultado esperado
* Los campos no son null
* El monto es mayor a cero

---

### IP-03

Verificacion de la relacion entre movimiento y metodo de pago

### Objetivo

Verificar que todo movimiento este
asociado a un metodo de pago.

## Resultado esperado
* Metodo de Pago no es null
* El nombre del metodo de pago no es null ni esta vacio

---
