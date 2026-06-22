START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `estado_ticket` (
                                 `id` int(11) NOT NULL,
                                 `nombre` varchar(20) NOT NULL,
                                 `descripcion` varchar(100) NOT NULL,
                                 `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `tipo_ticket` (
                               `id` int(11) NOT NULL,
                               `nombre` varchar(20) NOT NULL,
                               `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

CREATE TABLE `ticket` (
                          `id` int(11) NOT NULL,
                          `id_tipo` int(11) NOT NULL,
                          `id_estado` int(11) NOT NULL,
                          `prioridad` enum('ALTA','MEDIA','BAJA','') NOT NULL,
                          `fecha_creacion` datetime NOT NULL,
                          `fecha_cierre` datetime DEFAULT NULL,
                          `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------


--
ALTER TABLE `estado_ticket`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `ticket`
    ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo` (`id_tipo`),
  ADD KEY `id_estado` (`id_estado`);

ALTER TABLE `tipo_ticket`
    ADD PRIMARY KEY (`id`);


ALTER TABLE `estado_ticket`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `ticket`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `tipo_ticket`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `ticket`
    ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_estado`) REFERENCES `estado_ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

