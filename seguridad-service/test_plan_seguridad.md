# Plan de pruebas Microservicio de Seguridad GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de las clases Roles y Usuario

## Herramientas

* JUnit

## Caso de prueba

### SP-01

Registro de rol

### Objetivo

Verificar que el rol no contenga
campos nulos.

## Resultado esperado
* El rol contiene nombre y descripcion no nulos
* La lista de usuarios existe y esta vacia al momento de creacion

---

### SP-02

Registro de usuario

### Objetivo

Verificar que un usuario pueda
crearse correctamente.

## Resultado esperado
* Usuario creado y no nulo
* Username no es nulo ni vacío
* Email no es nulo ni vacío
* El rol asignado no es nulo


---

### SP-03

Verificacion de la existencia de una lista con usuarios

### Objetivo

Verificar que un usuario pueda enlazarse a
una lista para asociarse con un rol.

## Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un usuario
* La lista es asignada al rol


---


### SP-04

Eliminar un usuario

### Objetivo

Verificar la correcta eliminacion
de un usuario.

## Resultado esperado
* La lista ya no contiene al usuario
* Si no quedan usuarios en la lista no anularla, sino mantenerla vacia


---