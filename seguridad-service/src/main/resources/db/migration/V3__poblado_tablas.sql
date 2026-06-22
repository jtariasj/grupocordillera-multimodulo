INSERT INTO `roles` (`nombre`, `descripcion`) VALUES
    ('ADMIN', 'Acceso completo al sistema'),
    ('USER', 'Acceso limitado a funcionalidades básicas');


INSERT INTO `usuario` (`username`, `password`, `email`, `ultimo_acceso`, `id_rol`) VALUES
    ('jaimencio', 'claveSegura123', 'jaimencio@example.com', '2026-05-25', 1),
    ('lev', 'passLev456', 'lev@example.com', '2026-05-25', 2);

