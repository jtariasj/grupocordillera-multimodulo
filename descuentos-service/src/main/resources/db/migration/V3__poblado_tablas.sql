INSERT INTO `campanas_descuento` (`nombre`, `descripcion`, `fecha_inicio`, `fecha_fin`, `tipo_descuento`, `valor_descuento`, `presupuesto_maximo`, `canal`, `activo`) VALUES
    ('Cyber Day Mayo 2026', 'Gran evento de descuentos de mitad de año', '2026-05-25', '2026-05-28', 'PORCENTAJE', 25.00, 15000000.00, 'AMBOS', 1),
    ('Black Friday 2026', 'El evento más importante del año', '2026-11-20', '2026-11-30', 'PORCENTAJE', 30.00, 25000000.00, 'AMBOS', 1),
    ('Primera Compra', 'Descuento especial para nuevos clientes', '2026-01-01', '2026-12-31', 'PORCENTAJE', 15.00, 8000000.00, 'ONLINE', 1),
    ('Fidelidad Cliente', 'Beneficios para clientes frecuentes', '2026-01-01', '2026-12-31', 'MONTO_FIJO', 20000.00, 5000000.00, 'FISICO', 1);

INSERT INTO `reglas_descuento` (`id_campana`, `nombre_regla`, `descripcion`, `condicion`, `valor_condicion`, `prioridad`, `acumulable`, `activo`) VALUES
    (1, 'Descuento por monto mínimo', 'Compra sobre $50.000', 'MONTO_MINIMO', '50000', 1, 1, 1),
    (1, 'Descuento en Electrónica', 'Productos de la categoría Electrónica', 'CATEGORIA_PRODUCTO', 'ELECTRONICA', 2, 0, 1),
    (3, 'Descuento Primera Compra', 'Solo para clientes que compran por primera vez', 'PRIMERA_COMPRA', 'true', 1, 0, 1),
    (4, 'Cliente Frecuente', 'Clientes con más de 5 compras en el año', 'CLIENTE_FRECUENTE', '5', 1, 1, 1),
    (1, 'Cupón Cyber', 'Uso de cupón específico durante Cyber Day', 'CUPON', 'CYBER25', 3, 1, 1);

INSERT INTO `cupones` (`id_campana`, `codigo`, `descripcion`, `usos_maximos`, `usos_actuales`, `fecha_expiracion`, `descuento_adicional`, `solo_primer_uso`, `activo`) VALUES
    (1, 'CYBER25', '25% adicional en Cyber Day', 500, 45, '2026-05-28', 5.00, 0, 1),
    (1, 'BIENVENIDO15', '15% en tu primera compra', 1000, 320, '2026-12-31', 0.00, 1, 1),
    (2, 'BLACK30', '30% de descuento Black Friday', 800, 120, '2026-11-30', 10.00, 0, 1),
    (4, 'FIDEL20', 'Descuento especial clientes frecuentes', 300, 85, '2026-12-31', 0.00, 0, 1),
    (3, 'PRIMERA25', '25% en primera compra online', 600, 210, '2026-12-31', 0.00, 1, 1);