INSERT INTO `sucursal` (`nombre`, `direccion`, `activo`) VALUES
    ('Maipú', 'Av. Pajaritos 4500', 1),
    ('Providencia', 'Av. Providencia 2120', 1);

INSERT INTO `empleado` (`id_sucursal`, `run`, `dv`, `nombre`, `apellido_paterno`, `apellido_materno`, `correo`, `telefono`, `fecha_nacimiento`, `fecha_contrato`, `rol`, `activo`) VALUES
    (1, '12345678', '5', 'Juan', 'Pérez', 'González', 'juan.perez@grupocordillera.cl', '+56912345678', '1990-05-15', '2022-03-01', 'GERENTE_SUCURSAL', 1),
    (1, '11223344', '4', 'Carlos', 'Muñoz', 'Rojas', 'carlos.munoz@grupocordillera.cl', '+56911223344', '1995-11-10', '2023-06-01', 'VENDEDOR', 1),
    (2, '22334455', '2', 'Ana', 'Torres', 'Méndez', 'ana.torres@grupocordillera.cl', '+56922334455', '1991-03-25', '2022-05-10', 'GERENTE_SUCURSAL', 1),
    (2, '33445566', '7', 'Diego', 'Hernández', 'Vega', 'diego.hernandez@grupocordillera.cl', '+56933445566', '1994-07-12', '2023-02-20', 'VENDEDOR', 1);