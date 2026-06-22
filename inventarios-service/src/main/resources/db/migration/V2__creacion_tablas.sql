
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `categoria_producto` (
                                      `id` int(11) NOT NULL,
                                      `nombre` varchar(30) NOT NULL,
                                      `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

CREATE TABLE `producto` (
                            `id` int(11) NOT NULL,
                            `id_categoria_producto` int(11) NOT NULL,
                            `sku` varchar(12) NOT NULL,
                            `nombre` varchar(40) NOT NULL,
                            `descripcion` varchar(250) DEFAULT NULL,
                            `precio` int(7) NOT NULL,
                            `modelo` varchar(20) NOT NULL,
                            `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `categoria_producto`
    ADD PRIMARY KEY (`id`);


ALTER TABLE `producto`
    ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria_producto` (`id_categoria_producto`);


ALTER TABLE `categoria_producto`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `producto`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `producto`
    ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_categoria_producto`) REFERENCES `categoria_producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
