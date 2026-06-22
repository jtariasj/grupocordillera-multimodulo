SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `metodos_pago` (
                                `id` int(11) NOT NULL,
                                `nombre` varchar(100) NOT NULL,
                                `tipo` enum('EFECTIVO','TARJETA_DEBITO','TARJETA_CREDITO','TRANSFERENCIA','OTRO') NOT NULL,
                                `descripcion` varchar(255) DEFAULT NULL,
                                `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `movimientos_contables` (
                                         `id` int(11) NOT NULL,
                                         `tipo` enum('INGRESO','EGRESO') NOT NULL,
                                         `origen` enum('VENTA_FISICA','VENTA_ONLINE','DEVOLUCION','GASTO','OTRO') NOT NULL,
                                         `monto` double NOT NULL,
                                         `descripcion` varchar(255) DEFAULT NULL,
                                         `fecha` datetime NOT NULL,
                                         `id_metodo_pago` int(11) DEFAULT NULL,
                                         `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `metodos_pago`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);


ALTER TABLE `movimientos_contables`
    ADD PRIMARY KEY (`id`),
  ADD KEY `fk_movimiento_pago` (`id_metodo_pago`);


ALTER TABLE `metodos_pago`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `movimientos_contables`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `movimientos_contables`
    ADD CONSTRAINT `fk_movimiento_pago` FOREIGN KEY (`id_metodo_pago`) REFERENCES `metodos_pago` (`id`);
COMMIT;

