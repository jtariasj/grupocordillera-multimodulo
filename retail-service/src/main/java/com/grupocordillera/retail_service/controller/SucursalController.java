package com.grupocordillera.retail_service.controller;

import com.grupocordillera.retail_service.model.Sucursal;
import com.grupocordillera.retail_service.service.SucursalService;
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

@Tag(name = "Sucursales", description = "Operaciones relacionadas con las sucursales")
@RestController
@RequestMapping("api/v1/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService service;

    @Operation(summary = "Obtiene todo los detalles de las sucursales")
    @GetMapping
    public ResponseEntity<List<Sucursal>> listar(){
        List<Sucursal> sucursales = service.getSucursales();

        if(sucursales.isEmpty()){
            return ResponseEntity.noContent().build(); // 204
        }
        else{
            return ResponseEntity.ok(sucursales); // 200
        }
    }

    @Operation(summary = "Obtiene todo los detalles de una sucursal en específico")
    @GetMapping("/{id}")
    public EntityModel<Sucursal> buscarPorId(@PathVariable Integer id){

        Sucursal sucursal = service.getSucursal(id).orElseThrow();

        EntityModel<Sucursal> model = EntityModel.of(sucursal);

        model.add(
                linkTo(
                        methodOn(SucursalController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(SucursalController.class).listar()
                ).withRel("Todas-las-sucursales")
        );

        return model;

//        Optional<Sucursal> sucursal = service.getSucursal(id);
//
//        return sucursal
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea una nueva sucursal")
    @PostMapping
    public ResponseEntity<Sucursal> agregarSucursal(@RequestBody Sucursal sucursal){
        Sucursal nuevaSucursal = service.saveSucursal(sucursal);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .body(nuevaSucursal);
    }

    @Operation(summary = "Modifica el detalle de una sucursal en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> editar(@PathVariable Integer id, @RequestBody Sucursal sucursal){
        Optional<Sucursal> existe = service.getSucursal(id);

        if(existe.isEmpty()){
            return ResponseEntity.notFound().build(); // 404
        }
        else{
            sucursal.setId(id);

            Sucursal actualizado = service.saveSucursal(sucursal);
            return ResponseEntity.ok(actualizado); // 200
        }
    }

    @Operation(summary = "Borra una sucursal en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            service.deleteSucursal(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
