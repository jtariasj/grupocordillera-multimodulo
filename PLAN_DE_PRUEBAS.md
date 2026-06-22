# Plan de pruebas GrupoCordillera

## Objetivo
Validar el correcto funcionamiento de los
microservicios dentro del proyecto.

## Herramientas

* JUnit
* DataFaker

## Casos de prueba

## Microservicio de Atenciones

### Objetivo del módulo
Validar el correcto funcionamiento de las clases Ticket, EstadoTicket, TipoTicket

### AP-01

Crear tipo de ticket con datos válidos

#### Objetivo

Verificar que un tipo de ticket pueda crearse correctamente.

#### Resultado esperado
* El nombre no es null ni vacios
* La lista de tickets existe y está vacia

---

### AP-02

Crear estado de ticket con datos válidos

#### Objetivo

Verificar que un estado de ticket pueda crearse correctamente.

#### Resultado esperado
* El nombre no es null ni vacios
* La lista de tickets existe y está vacia

---

### AP-03

Crear ticket con datos válidos

#### Objetivo

Verificar que un ticket pueda crearse correctamente.

#### Resultado esperado
* El tipo de ticket no es null
* El estado del ticket no es null
* La prioridad no es null
* La fecha de creacion no es null

---

### AP-04

Verificar que la fecha de creacion sea anterior
a la fecha de cierre.

#### Objetivo

Verificar coherencia de fechas del ticket.

#### Resultado esperado
* La fecha del cierre es posterior o igual a la fecha de creacion

---

### AP-05

Agregar ticket a tipo de ticket

#### Objetivo

Verificar que un ticket pueda asociarse a un tipo de ticket.

#### Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un ticket
* La lista de tickets es asignada al tipo de ticket

---

## Microservicio de Descuentos

### Objetivo del módulo
Validar el correcto funcionamiento de la clase Metrica

### DP-01

Crear campana de descuento con datos validos

#### Objetivo

Verificar que la metrica pueda crearse
correctamente.

#### Resultado esperado
* El nombre y descripción no null ni vacíos
* El valor del descuento es mayor a cero
* El presupuesto es mayor a cero
* La lista de reglas y cupones existen y están vacías

---

### DP-02

Verificar que fechaFin no sea anterior a fechaInicio

#### Objetivo

Verificar coherencia de fechas de la campana.

#### Resultado esperado
* La fecha de inicio debe ser anterior a la del fin

---

### DP-03

Crear cupón con datos válidos

#### Objetivo

Verificar que un cupón pueda
crearse correctamente.

#### Resultado esperado
* El codigo no nulo ni vacío
* Los usos actuales son 0 inicialmente
* Los usos maximos son mayores a cero

---

### DP-04

Verificar que un cupón tenga usos disponibles

#### Objetivo

Verificar que el cupón pueda usarse.

#### Resultado esperado
* Los usos actuales son menores a los maximos

---

### DP-05

Crear regla de descuento con datos válidos

#### Objetivo

Verificar que una regla pueda crearse correctamente.

#### Resultado esperado
* El nombre de la regla no es null ni vacío
* La condicion no es null ni vacio

---

## Microservicio de Desempeño

### Objetivo del módulo
Validar el correcto funcionamiento de la clase Metrica

### DeP-01

Crear metrica con datos validos

#### Objetivo

Verificar que la metrica pueda crearse
correctamente.

#### Resultado esperado
* El nombre de la metrica no esta vacia y no es null
* La unidad de medida no esta vacia y no es null
* El valor actual y la meta no pueden ser negativos

---

### DeP-02

Verificacion del momento en el
que la metrica alcanza su objetivo

#### Objetivo

Verificar cuando el valor actual es igual
o mayor a la meta.

#### Resultado esperado
* El valor actual >= meta objetivo

---

### DeP-03

Verificacion de que la metrica no ha
alcanzado el objetivo

#### Objetivo

Verificar cuando el valor actual es
menor a la meta.

#### Resultado esperado
* El valor actual < meta objetivo

---

## Microservicio de E-Commerce

### Objetivo del módulo
Validar el correcto funcionamiento de las clases Producto online y Cliente digital

### EP-01

Crear cliente con datos validos

#### Objetivo

Verificar que el cliente pueda crearse
correctamente.

#### Resultado esperado
* El nombre y apellido del cliente no esta vacio y no es null
* El email no es null ni vacio
* El pedido con la lista de productos existe y esta vacia

---

### EP-02

Crear pedido con datos validos

#### Objetivo

Verificar que un pedido puede crearse
correctamente.

#### Resultado esperado
* El numero del pedido no es null ni vacio
* El cliente no es null
* La direccion de entrega no es null ni vacio
* El total es mayor a cero
* El estado es "PENDIENTE" por defecto

---

### EP-03

Agregar pedido a cliente

#### Objetivo

Verificar que el pedido con productos
puede asociarse con un cliente.

#### Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un producto
* La lista de productos es asignada a la categoria

---

### EP-04

Eliminar pedidos de cliente

#### Objetivo

Verificar que un pedido puede
desvincularse de un cliente.

#### Resultado esperado
* La lista ya no contiene al pedido
* La lista queda vacia pero no null

---

## Microservicio de Inventario

### Objetivo del módulo
Validar el correcto funcionamiento de las clases Producto y CategoriaProducto

### IP-01

Crear categoria con datos validos

#### Objetivo

Verificar que la categoria pueda crearse
correctamente.

#### Resultado esperado
* El nombre de la categoria no esta vacia y no es null
* La lista de productos existe y esta vacia al momento de creacion

---

### IP-02

Crear producto con datos validos

#### Objetivo

Verificar que un producto puede crearse
correctamente.

#### Resultado esperado
* El Sku no es null ni vacio
* El nombre no es null
* El precio es mayor a cero
* El modelo no es null

---

### IP-03

Verificacion de la existencia de una lista con productos

#### Objetivo

Verificar que un producto puede relacionarse
a una categoria.

#### Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un producto
* La lista de productos es asignada a la categoria

---

### IP-04

Eliminar producto de categoria

#### Objetivo

Verificar que un producto puede
desvincularse de una categoria.

#### Resultado esperado
* La lista ya no contiene al producto
* La lista queda vacia pero no null

---

## Microservicio de Finanzas

### Objetivo del módulo
Validar el correcto funcionamiento de las clases Metodo de pago y Movimiento contable

### FP-01

Crear metodo de pago con datos validos

#### Objetivo

Verificar que un metodo de pago pueda crearse
correctamente.

#### Resultado esperado
* El nombre de la categoria no esta vacia y no es null
* El tipo no es null
* La lista de productos existe y esta vacia al momento de creacion

---

### FP-02

Crear movimientos con datos validos

#### Objetivo

Verificar que un movimiento puede crearse
correctamente.

#### Resultado esperado
* Los campos no son null
* El monto es mayor a cero

---

### FP-03

Verificacion de la relacion entre movimiento y metodo de pago

#### Objetivo

Verificar que todo movimiento este
asociado a un metodo de pago.

#### Resultado esperado
* Metodo de Pago no es null
* El nombre del metodo de pago no es null ni esta vacio

---

## Microservicio de Retail

### Objetivo del módulo
Validar el correcto funcionamiento de las clases Sucursal y Empleado

### ReP-01

Crear sucursal con datos validos

#### Objetivo

Verificar que la sucursal no contenga
campos nulos.

#### Resultado esperado
* La sucursal contiene nombre y descripcion no nulos
* La lista de empleados existe y esta vacia al momento de creacion

---

### ReP-02

Crear empleado con datos validos

#### Objetivo

Verificar que el empleado
pueda crearse correctamente.

#### Resultado esperado
* Todos los campos no son nulos
* El empleado tiene una sucursal asignada

---

### ReP-03

Verificacion de la existencia de una lista con empleados

#### Objetivo

Verificar que una empleado puede relacionarse
a una sucursal.

#### Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un empleado
* La lista de empleados es asignada a la sucursal

---

### ReP-04

Verificar tiempo entre periodos correctos

#### Objetivo

Verificar que la fecha del contrato
sea luego de la fecha de nacimiento.

#### Resultado esperado
* La fecha del contrato ocurre despues de la del nacimiento

---

### ReP-05

Eliminar un empleado de sucursal

#### Objetivo

Verificar que un empleado es eliminado
de una sucursal.

#### Resultado esperado
* La lista ya no contiene al empleado
* La lista queda vacia pero no nula

---

## Microservicio de POS

### Objetivo del módulo
Validar el correcto funcionamiento de las clases VentaFisica y DetalleVenta

### PP-01

Crear venta con datos validos

#### Objetivo

Verificar que la venta no contenga
campos nulos.

#### Resultado esperado
* El numero de la boleta no es null ni vacío
* El total debe ser mayor a cero
* El estado es "PENDIENTE" por defecto
* La lista de detalles existe y está vacía

---

### PP-02

Crear detalle de venta con datos validos

#### Objetivo

Verificar que el detalle de las ventas
pueda crearse correctamente.

#### Resultado esperado
* El nombre del producto no es null
* La cantidad de productos es mayor a cero
* El precio unitario del producto es mayor a cero

---

### PP-03

Calcular subtotal de los productos

#### Objetivo
Verificar que el subtotal sea igual a cantidad*precio - descuento.

#### Resultado esperado
* El subtotal es correctamente calculado

---

### PP-04

Agregar detalles a la venta

#### Objetivo

Verificar que la venta tenga detalles de productos.

#### Resultado esperado
* La lista contiene detalles de productos
* La lista tiene al menos un producto con sus detalles
* A la venta se le asigna la lista con los productos

---

## Microservicio de Reportes

### Objetivo del módulo
Validar el correcto funcionamiento de la clase Reportes

### RP-01

Crear reporte con datos validos

#### Objetivo

Verificar que un reporte pueda
crearse correctamente.

#### Resultado esperado
* El titulo no es nulo
* El tipo de reporte no es nulo
* El estado del reporte no es nulo

---

## Microservicio de Seguridad

### Objetivo del módulo
Validar el correcto funcionamiento de las clases Roles y Usuario

### SP-01

Registro de rol

#### Objetivo

Verificar que el rol no contenga
campos nulos.

#### Resultado esperado
* El rol contiene nombre y descripcion no nulos
* La lista de usuarios existe y esta vacia al momento de creacion

---

### SP-02

Registro de usuario

#### Objetivo

Verificar que un usuario pueda
crearse correctamente.

#### Resultado esperado
* Usuario creado y no nulo
* Username no es nulo ni vacío
* Email no es nulo ni vacío
* El rol asignado no es nulo

---

### SP-03

Verificacion de la existencia de una lista con usuarios

#### Objetivo

Verificar que un usuario pueda enlazarse a
una lista para asociarse con un rol.

#### Resultado esperado
* La lista ya esta creada
* La lista tiene al menos un usuario
* La lista es asignada al rol

---

### SP-04

Eliminar un usuario

#### Objetivo

Verificar la correcta eliminacion
de un usuario.

#### Resultado esperado
* La lista ya no contiene al usuario
* Si no quedan usuarios en la lista no anularla, sino mantenerla vacia

---