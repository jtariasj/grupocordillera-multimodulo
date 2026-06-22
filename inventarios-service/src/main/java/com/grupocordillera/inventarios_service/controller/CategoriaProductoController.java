package com.grupocordillera.inventarios_service.controller;


import com.grupocordillera.inventarios_service.model.CategoriaProducto;
import com.grupocordillera.inventarios_service.service.CategoriaProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Categorías", description = "Operaciones relacionadas con las categorías de los productos")
@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService service;

    @Operation(summary = "Obtiene todo los detalles de las categorías")
    @GetMapping
    public ResponseEntity<List<CategoriaProducto>> listar(){
        List<CategoriaProducto> categorias = service.getCategorias();

        if(categorias.isEmpty()){
            return ResponseEntity.noContent().build(); // 204
        }
        else{
            return ResponseEntity.ok(categorias); // 200
        }
    }

    @Operation(summary = "Obtiene todo los detalles de una categoría en específico")
    @GetMapping("/{id}")
    public EntityModel<CategoriaProducto> buscarPorId(@PathVariable Integer id){
        CategoriaProducto categoriaProducto = service.getCategoria(id).orElseThrow();

        EntityModel<CategoriaProducto> model = EntityModel.of(categoriaProducto);

        model.add(
                linkTo(
                        methodOn(ProductoController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(ProductoController.class).listar()
                ).withRel("Todas-las-categorias")
        );

        return model;

//        Optional<CategoriaProducto> categoria = service.getCategoria(id);
//
//        return categoria
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea una nueva categoria")
    @PostMapping
    public ResponseEntity<CategoriaProducto> agregar(@RequestBody CategoriaProducto categoria){
        CategoriaProducto nuevaCategoria = service.saveCategoria(categoria);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .body(nuevaCategoria);
    }

    @Operation(summary = "Modifica el detalle de una categoria en específico")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProducto> editar(@PathVariable Integer id, @RequestBody CategoriaProducto categoria){
        Optional<CategoriaProducto> existe = service.getCategoria(id);

        if(existe.isEmpty()){
            return ResponseEntity.notFound().build(); // 404
        }
        else{
            categoria.setId(id);

            CategoriaProducto actualizado = service.saveCategoria(categoria);
            return ResponseEntity.ok(actualizado); // 200
        }
    }

    @Operation(summary = "Borra una categoria en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            service.deleteCategoria(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
