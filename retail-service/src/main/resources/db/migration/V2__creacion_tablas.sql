SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `sucursal` (
                            `id` int(11) NOT NULL,
                            `nombre` varchar(20) NOT NULL,
                            `direccion` varchar(30) NOT NULL,
                            `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `empleado` (
                            `id` int(11) NOT NULL,
                            `id_sucursal` int(11) NOT NULL,
                            `run` varchar(8) NOT NULL,
                            `dv` varchar(1) NOT NULL,
                            `nombre` varchar(20) NOT NULL,
                            `apellido_paterno` varchar(20) NOT NULL,
                            `apellido_materno` varchar(20) NOT NULL,
                            `correo` varchar(50) NOT NULL,
                            `telefono` varchar(12) NOT NULL,
                            `fecha_nacimiento` date NOT NULL,
                            `fecha_contrato` date NOT NULL,
                            `rol` varchar(20) NOT NULL,
                            `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------
ALTER TABLE `sucursal`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `empleado`
    ADD PRIMARY KEY (`id`),
  ADD KEY `id_sucursal` (`id_sucursal`);


ALTER TABLE `empleado`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `sucursal`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `empleado`
    ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
