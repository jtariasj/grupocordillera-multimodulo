SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `campanas_descuento` (
                                      `id_campana` int(11) NOT NULL,
                                      `nombre` varchar(150) NOT NULL,
                                      `descripcion` varchar(500) NOT NULL,
                                      `fecha_inicio` date NOT NULL,
                                      `fecha_fin` date NOT NULL,
                                      `tipo_descuento` enum('PORCENTAJE','MONTO_FIJO') NOT NULL,
                                      `valor_descuento` double NOT NULL,
                                      `presupuesto_maximo` double NOT NULL DEFAULT 0,
                                      `canal` enum('FISICO','ONLINE','AMBOS') NOT NULL DEFAULT 'AMBOS',
                                      `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `cupones` (
                           `id_cupon` int(11) NOT NULL,
                           `id_campana` int(11) NOT NULL,
                           `codigo` varchar(50) NOT NULL,
                           `descripcion` varchar(255) DEFAULT NULL,
                           `usos_maximos` int(11) NOT NULL DEFAULT 1,
                           `usos_actuales` int(11) NOT NULL DEFAULT 0,
                           `fecha_expiracion` date NOT NULL,
                           `descuento_adicional` double NOT NULL DEFAULT 0,
                           `solo_primer_uso` tinyint(1) NOT NULL DEFAULT 0,
                           `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `reglas_descuento` (
                                    `id_regla` int(11) NOT NULL,
                                    `id_campana` int(11) NOT NULL,
                                    `nombre_regla` varchar(150) NOT NULL,
                                    `descripcion` varchar(500) DEFAULT NULL,
                                    `condicion` enum('MONTO_MINIMO','CATEGORIA_PRODUCTO','CLIENTE_FRECUENTE','PRIMERA_COMPRA','CUPON') NOT NULL,
                                    `valor_condicion` varchar(100) NOT NULL,
                                    `prioridad` int(11) NOT NULL DEFAULT 1,
                                    `acumulable` tinyint(1) NOT NULL DEFAULT 0,
                                    `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `campanas_descuento`
    ADD PRIMARY KEY (`id_campana`);


ALTER TABLE `cupones`
    ADD PRIMARY KEY (`id_cupon`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `fk_cupon_campana` (`id_campana`);

ALTER TABLE `reglas_descuento`
    ADD PRIMARY KEY (`id_regla`),
  ADD KEY `fk_regla_campana` (`id_campana`);


ALTER TABLE `campanas_descuento`
    MODIFY `id_campana` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `cupones`
    MODIFY `id_cupon` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `reglas_descuento`
    MODIFY `id_regla` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `cupones`
    ADD CONSTRAINT `fk_cupon_campana` FOREIGN KEY (`id_campana`) REFERENCES `campanas_descuento` (`id_campana`);


ALTER TABLE `reglas_descuento`
    ADD CONSTRAINT `fk_regla_campana` FOREIGN KEY (`id_campana`) REFERENCES `campanas_descuento` (`id_campana`);
COMMIT;
