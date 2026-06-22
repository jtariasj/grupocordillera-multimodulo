SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `metrica` (
                           `id` int(11) NOT NULL,
                           `nombre` varchar(100) NOT NULL,
                           `valor_actual` double NOT NULL,
                           `meta_objetivo` double NOT NULL,
                           `unidad_medida` varchar(50) NOT NULL,
                           `ultima_actualizacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `metrica`
    ADD PRIMARY KEY (`id`);


ALTER TABLE `metrica`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;
