INSERT INTO `tipo_ticket` (`nombre`, `activo`) VALUES
    ('Reclamo', 1),
    ('Devolución', 1),
    ('Garantía', 1),
    ('Consulta', 1),
    ('Sugerencia', 1),
    ('Soporte Técnico', 1);

INSERT INTO `estado_ticket` (`nombre`, `descripcion`, `activo`) VALUES
    ('ABIERTO', 'Ticket recién creado y pendiente de atención', 1),
    ('EN_PROCESO', 'El ticket está siendo atendido por un agente', 1),
    ('ESPERANDO_CLIENTE', 'Esperando respuesta o información del cliente', 1),
    ('RESUELTO', 'El problema ha sido solucionado', 1),
    ('CERRADO', 'Ticket cerrado definitivamente', 1),
    ('CANCELADO', 'El ticket fue cancelado por el cliente', 1);

INSERT INTO `ticket` (`id_tipo`, `id_estado`, `prioridad`, `fecha_creacion`, `fecha_cierre`, `activo`) VALUES
    (1, 1, 'ALTA',  '2026-05-20 09:15:00', NULL, 1),
    (2, 4, 'MEDIA', '2026-05-18 14:30:00', '2026-05-22 11:45:00', 1),
    (3, 2, 'ALTA',  '2026-05-21 10:05:00', NULL, 1),
    (4, 1, 'BAJA',  '2026-05-22 16:20:00', NULL, 1),
    (6, 3, 'MEDIA', '2026-05-19 08:45:00', NULL, 1),
    (1, 5, 'ALTA',  '2026-05-15 11:10:00', '2026-05-20 17:30:00', 1),
    (5, 4, 'BAJA',  '2026-05-20 13:55:00', '2026-05-23 09:00:00', 1),
    (3, 2, 'MEDIA', '2026-05-24 09:30:00', NULL, 1),
    (2, 6, 'ALTA',  '2026-05-17 15:40:00', '2026-05-21 12:15:00', 1);