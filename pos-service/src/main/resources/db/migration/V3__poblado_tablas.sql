INSERT INTO `ventas_fisicas` (`numero_boleta`, `fecha_venta`, `total`, `estado`, `activo`) VALUES
    ('B001-2026-00045', '2026-05-20 10:35:00', 899990.00, 'COMPLETADA',1),
    ('B001-2026-00046', '2026-05-22 12:15:00', 1249990.00, 'COMPLETADA',1),
    ('B001-2026-00047', '2026-05-25 16:45:00', 459990.00, 'COMPLETADA',1),
    ('B001-2026-00048', '2026-05-27 11:20:00', 189990.00, 'PENDIENTE',1);

INSERT INTO `detalle_ventas` (`id_venta`, `nombre_producto`, `cantidad`, `precio_unitario`, `subtotal`, `descuento`, `activo`) VALUES
    (1, 'Televisor LED Samsung 55"', 1, 899990.00, 899990.00, 0.00, 1),
    (2, 'Refrigerador No Frost LG 450L', 1, 1249990.00, 1249990.00, 0.00, 1),
    (3, 'Lavadora Samsung 18kg', 1, 459990.00, 459990.00, 0.00, 1),
    (4, 'Laptop Lenovo IdeaPad Ryzen 5', 1, 549990.00, 549990.00, 0.00, 1),
    (4, 'Mouse Inalámbrico Logitech', 2, 14990.00, 29980.00, 5000.00, 1),
    (4, 'Audífonos Bluetooth Sony', 1, 89990.00, 89990.00, 0.00, 1);