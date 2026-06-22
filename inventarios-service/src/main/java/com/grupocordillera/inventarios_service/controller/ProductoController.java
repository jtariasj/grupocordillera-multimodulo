package com.grupocordillera.inventarios_service.controller;

import com.grupocordillera.inventarios_service.model.Producto;
import com.grupocordillera.inventarios_service.service.ProductoService;
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

@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")
@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Operation(summary = "Obtiene todo los detalles de los productos")
    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> productos = productoService.getProductos();

        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();  //204
        }
        else{
            return ResponseEntity.ok(productos); //200
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un producto en específico")
    @GetMapping("/{id}")
    public EntityModel<Producto> buscarPorId(@PathVariable Integer id){
        Producto producto = productoService.getProducto(id).orElseThrow();

        EntityModel<Producto> model = EntityModel.of(producto);

        model.add(
                linkTo(
                        methodOn(ProductoController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(ProductoController.class).listar()
                ).withRel("Todos-los-productos")
        );

        return model;
//        Optional<Producto> producto = productoService.getProducto(id);
//
//        return producto
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea un nuevo producto")
    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto){
        Producto nuevoProducto = productoService.saveProducto(producto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoProducto);
    }

    @Operation(summary = "Modifica el detalle de un producto en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editar(@PathVariable Integer id, @RequestBody Producto producto){
        Optional<Producto> existe = productoService.getProducto(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            producto.setId(id);
            Producto actualizado = productoService.saveProducto(producto);
            return ResponseEntity.ok(actualizado);
        }
    }

    @Operation(summary = "Borra un producto en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            productoService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
