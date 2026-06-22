package com.grupocordillera.inventarios_service.repository;

import com.grupocordillera.inventarios_service.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
