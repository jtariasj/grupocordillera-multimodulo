package com.grupocordillera.inventarios_service.service;

import com.grupocordillera.inventarios_service.model.CategoriaProducto;
import com.grupocordillera.inventarios_service.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    public List<CategoriaProducto> getCategorias() { return categoriaProductoRepository.findAll();}

    public Optional<CategoriaProducto> getCategoria(Integer id) { return categoriaProductoRepository.findById(id);}

    public CategoriaProducto saveCategoria(CategoriaProducto categoria) { return categoriaProductoRepository.save(categoria);}

    public CategoriaProducto updateCategoria(Integer id, CategoriaProducto categoria){
        Optional existe = getCategoria(id);

        if(existe.isEmpty()){
            throw new RuntimeException("No encontrado");
        }
        else{
            return categoriaProductoRepository.save(categoria);
        }
    }

    public void deleteCategoria(Integer id){
        if(categoriaProductoRepository.existsById(id)){
            categoriaProductoRepository.deleteById(id);
        }
        else{
            throw new RuntimeException(("No encontrado"));
        }
    }
}
