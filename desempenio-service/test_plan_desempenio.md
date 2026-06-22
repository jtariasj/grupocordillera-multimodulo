# Plan de pruebas Microservicio de Desempenio GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de la clase Metrica

## Herramientas

* JUnit

## Caso de prueba

### DeP-01

Crear metrica con datos validos

### Objetivo

Verificar que la metrica pueda crearse
correctamente.

## Resultado esperado
* El nombre de la metrica no esta vacia y no es null
* La unidad de medida no esta vacia y no es null
* El valor actual y la meta no pueden ser negativos

---

### DeP-02

Verificacion del momento en el
que la metrica alcanza su objetivo

### Objetivo

Verificar cuando el valor actual es igual
o mayor a la meta.

## Resultado esperado
* El valor actual >= meta objetivo

---

### DeP-03

Verificacion de que la metrica no ha
alcanzado el objetivo

### Objetivo

Verificar cuando el valor actual es
menor a la meta.

## Resultado esperado
* El valor actual < meta objetivo

---
