INSERT INTO `clientes_digitales` (`nombre`, `apellido`, `email`, `telefono`, `direccion`, `fecha_registro`, `ultimo_acceso`, `activo`) VALUES
    ('Camila', 'Rodríguez', 'camila.rodriguez@gmail.com', '+56987654321', 'Av. Alameda 2450, Santiago', '2025-11-10 10:30:00', '2026-05-27 18:45:00', 1),
    ('Matías', 'Silva', 'matias.silva@hotmail.com', '+56911223344', 'Calle Los Leones 890, Providencia', '2025-08-15 14:20:00', '2026-05-28 09:15:00', 1),
    ('Valentina', 'Muñoz', 'valentina.munoz@outlook.com', '+56955443322', 'Av. Vicuña Mackenna 3200, La Florida', '2026-01-05 11:00:00', '2026-05-26 16:30:00', 1),
    ('Diego', 'Fernández', 'diego.fernandez@gmail.com', '+56999887766', 'Calle Arturo Prat 145, Viña del Mar', '2025-09-20 09:45:00', '2026-05-28 11:20:00', 1);

INSERT INTO `pedidos_online` (`numero_pedido`, `id_cliente`, `fecha_pedido`, `direccion_entrega`, `total`, `estado`, `activo`) VALUES
    ('PED-2026-00045', 1, '2026-05-20 10:15:00', 'Av. Alameda 2450, Santiago', 125990.50, 'ENTREGADO', 1),
    ('PED-2026-00046', 2, '2026-05-22 15:40:00', 'Calle Los Leones 890, Providencia', 89990.00, 'DESPACHADO', 1),
    ('PED-2026-00047', 3, '2026-05-25 09:05:00', 'Av. Vicuña Mackenna 3200, La Florida', 245000.75, 'CONFIRMADO', 1),
    ('PED-2026-00048', 4, '2026-05-27 14:30:00', 'Calle Arturo Prat 145, Viña del Mar', 67990.00, 'PENDIENTE', 1);