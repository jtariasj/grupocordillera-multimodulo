INSERT INTO `categoria_producto` (`nombre`, `activo`) VALUES
    ('Limpieza Inteligente', 1),
    ('Iluminación Inteligente', 1);

INSERT INTO `producto` (`id_categoria_producto`, `sku`, `nombre`, `descripcion`, `precio`, `modelo`, `activo`) VALUES
                                                                                                                   (1, 'HT-HOME-0047', 'Aspiradora Robot WiFi','Aspiradora robot inteligente con mapeo láser, control por app y programación semanal. Ideal para hogares con mascotas.',45990, 'X8-Pro', 1),
                                                                                                                   (2, 'SMARTLAMP01', 'Lámpara LED Inteligente','Lámpara LED WiFi 9W controlable por app, compatible con Alexa y Google Home, 16 millones de colores',24990, 'LUMIS-9W-WIFI', 1);