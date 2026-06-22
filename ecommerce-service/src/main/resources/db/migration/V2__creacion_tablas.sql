SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `clientes_digitales` (
                                      `id` int(11) NOT NULL,
                                      `nombre` varchar(150) NOT NULL,
                                      `apellido` varchar(150) NOT NULL,
                                      `email` varchar(255) NOT NULL,
                                      `telefono` varchar(20) DEFAULT NULL,
                                      `direccion` varchar(255) DEFAULT NULL,
                                      `fecha_registro` datetime NOT NULL,
                                      `ultimo_acceso` datetime DEFAULT NULL,
                                      `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `pedidos_online` (
                                  `id` int(11) NOT NULL,
                                  `numero_pedido` varchar(50) NOT NULL,
                                  `id_cliente` int(11) NOT NULL,
                                  `fecha_pedido` datetime NOT NULL,
                                  `direccion_entrega` varchar(255) NOT NULL,
                                  `total` double NOT NULL,
                                  `estado` enum('PENDIENTE','CONFIRMADO','DESPACHADO','ENTREGADO','CANCELADO') NOT NULL DEFAULT 'PENDIENTE',
                                  `activo` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `clientes_digitales`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);


ALTER TABLE `pedidos_online`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_pedido` (`numero_pedido`),
  ADD KEY `fk_pedido_cliente` (`id_cliente`);


ALTER TABLE `clientes_digitales`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `pedidos_online`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `pedidos_online`
    ADD CONSTRAINT `fk_pedido_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes_digitales` (`id`);
COMMIT;

