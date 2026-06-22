INSERT INTO `metodos_pago` (`nombre`, `tipo`, `descripcion`, `activo`) VALUES
    ('Efectivo', 'EFECTIVO', 'Pago en moneda física en caja', 1),
    ('WebPay Crédito', 'TARJETA_CREDITO', 'Pago con tarjeta de crédito a través de WebPay', 1),
    ('WebPay Débito', 'TARJETA_DEBITO', 'Pago con tarjeta de débito a través de WebPay', 1),
    ('Transferencia Bancaria', 'TRANSFERENCIA', 'Transferencia electrónica a cuenta bancaria', 1),
    ('Mercado Pago', 'TARJETA_CREDITO', 'Pago a través de la plataforma Mercado Pago', 1),
    ('Crédito Tienda', 'OTRO', 'Pago con crédito otorgado por Grupo Cordillera', 1);

INSERT INTO `movimientos_contables` (`tipo`, `origen`, `monto`, `descripcion`, `fecha`, `id_metodo_pago`, `activo`) VALUES
    ('INGRESO', 'VENTA_FISICA', 899990.00, 'Venta de Televisor Samsung 55"', '2026-05-20 10:45:00', 1, 1),
    ('INGRESO', 'VENTA_FISICA', 1249990.00, 'Venta de Refrigerador LG 450L', '2026-05-22 12:30:00', 2, 1),
    ('INGRESO', 'VENTA_ONLINE', 245000.75, 'Pedido online #PED-2026-00047', '2026-05-25 09:20:00', 3, 1),
    ('INGRESO', 'VENTA_FISICA', 189990.00, 'Venta de accesorios varios', '2026-05-27 11:35:00', 1, 1),
    ('EGRESO', 'GASTO', 45000.00, 'Pago de luz sucursal Maipú', '2026-05-21 08:00:00', 4, 1),
    ('EGRESO', 'DEVOLUCION', 899990.00, 'Devolución de Televisor defectuoso', '2026-05-23 14:15:00', 2, 1),
    ('INGRESO', 'VENTA_ONLINE', 67990.00, 'Pedido online #PED-2026-00048', '2026-05-27 15:10:00', 5, 1),
    ('EGRESO', 'GASTO', 1250000.00, 'Pago de mercadería a proveedor', '2026-05-26 09:00:00', 4, 1);