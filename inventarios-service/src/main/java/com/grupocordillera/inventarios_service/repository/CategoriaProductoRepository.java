package com.grupocordillera.inventarios_service.repository;

import com.grupocordillera.inventarios_service.model.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {
}
