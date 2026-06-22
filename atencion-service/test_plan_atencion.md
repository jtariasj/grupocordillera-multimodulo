# Plan de pruebas Microservicio de Atenciones GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de las clases Ticket, EstadoTicket, TipoTicket

## Herramientas

* JUnit

## Caso de prueba

### AP-01

Crear tipo de ticket con datos válidos

### Objetivo

Verificar que un tipo de ticket pueda crearse correctamente.

## Resultado esperado
* El nombre no es null ni vacios
* La lista de tickets existe y está vacia

---

### AP-02

Crear estado de ticket con datos válidos

### Objetivo

Verificar que un estado de ticket pueda crearse correctamente.

## Resultado esperado
* El nombre no es null ni vacios
* La lista de tickets existe y está vacia

---

### AP-03

Crear ticket con datos válidos

### Objetivo

Verificar que un ticket pueda crearse correctamente.

## Resultado esperado
* El tipo de ticket no es null
* El estado del ticket no es null
* La prioridad no es null
* La fecha de creacion no es null

---
### DP-04

Verificar que la fecha de creacion sea anterior
a la fecha de cierre.

### Objetivo

Verificar coherencia de fechas del ticket.

## Resultado esperado
* La fecha del cierre es posterior o igual a la fecha de creacion

---
### DP-05

Agregar ticket a tipo de ticket

### Objetivo

Verificar que un ticket pueda asociarse a un tipo de ticket.

## Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un ticket
* La lista de tickets es asignada al tipo de ticket


---
