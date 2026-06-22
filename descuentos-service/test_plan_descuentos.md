# Plan de pruebas Microservicio de Descuentos GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de la clase Metrica

## Herramientas

* JUnit

## Caso de prueba

### DP-01

Crear campana de descuento con datos validos

### Objetivo

Verificar que la metrica pueda crearse
correctamente.

## Resultado esperado
* El nombre y descripción no null ni vacíos
* El valor del descuento es mayor a cero
* El presupuesto es mayor a cero
* La lista de reglas y cupones existen y están vacías

---

### DP-02

Verificar que fechaFin no sea anterior a fechaInicio

### Objetivo

Verificar coherencia de fechas de la campana.

## Resultado esperado
* La fecha de inicio debe ser anterior a la del fin

---

### DP-03

Crear cupón con datos válidos

### Objetivo

Verificar que un cupón pueda
crearse correctamente.

## Resultado esperado
* El codigo no nulo ni vacío
* Los usos actuales son 0 inicialmente
* Los usos maximos son mayores a cero

---
### DP-04

Verificar que un cupón tenga usos disponibles

### Objetivo

Verificar que el cupón pueda usarse.

## Resultado esperado
* Los usos actuales son menores a los maximos

---
### DP-05

Crear regla de descuento con datos válidos

### Objetivo

Verificar que una regla pueda crearse correctamente.

## Resultado esperado
* El nombre de la regla no es null ni vacío
* La condicion no es null ni vacio

---
