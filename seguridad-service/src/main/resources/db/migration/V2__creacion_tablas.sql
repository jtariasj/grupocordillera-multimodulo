SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `roles` (
                         `id_rol` int(11) NOT NULL,
                         `nombre` varchar(100) NOT NULL,
                         `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `usuario` (
                           `id_usuario` int(11) NOT NULL,
                           `username` varchar(100) NOT NULL,
                           `password` varchar(255) NOT NULL,
                           `email` varchar(150) NOT NULL,
                           `ultimo_acceso` date DEFAULT NULL,
                           `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `roles`
    ADD PRIMARY KEY (`id_rol`);

ALTER TABLE `usuario`
    ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_rol` (`id_rol`);

ALTER TABLE `roles`
    MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `usuario`
    MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `usuario`
    ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);
COMMIT;