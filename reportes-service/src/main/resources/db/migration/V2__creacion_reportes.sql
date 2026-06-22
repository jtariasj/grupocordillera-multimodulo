SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `reporte` (
                           `id` int(11) NOT NULL,
                           `titulo` varchar(50) NOT NULL,
                           `tipo_reporte` varchar(50) NOT NULL,
                           `fecha_generacion` datetime NOT NULL,
                           `id_usuario` int(11) NOT NULL,
                           `estado_reporte` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `reporte`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `reporte`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;
