SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `detalle_ventas` (
                                  `id` int(11) NOT NULL,
                                  `id_venta` int(11) NOT NULL,
                                  `nombre_producto` varchar(255) NOT NULL,
                                  `cantidad` int(11) NOT NULL,
                                  `precio_unitario` double NOT NULL,
                                  `subtotal` double NOT NULL,
                                  `descuento` double NOT NULL DEFAULT 0,
                                  `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `ventas_fisicas` (
                                  `id` int(11) NOT NULL,
                                  `numero_boleta` varchar(50) NOT NULL,
                                  `fecha_venta` datetime NOT NULL,
                                  `total` double NOT NULL,
                                  `estado` enum('PENDIENTE','COMPLETADA','ANULADA') NOT NULL DEFAULT 'PENDIENTE',
                                  `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `detalle_ventas`
    ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detalle_venta` (`id_venta`);

ALTER TABLE `ventas_fisicas`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_boleta` (`numero_boleta`);


ALTER TABLE `detalle_ventas`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `ventas_fisicas`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `detalle_ventas`
    ADD CONSTRAINT `fk_detalle_venta` FOREIGN KEY (`id_venta`) REFERENCES `ventas_fisicas` (`id`);
COMMIT;
