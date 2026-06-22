package com.grupocordillera.descuentos_service.controller;

import com.grupocordillera.descuentos_service.model.Cupon;
import com.grupocordillera.descuentos_service.service.CuponService;
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

@Tag(name = "Cupones", description = "Operaciones relacionadas con los cupones")
@RestController
@RequestMapping("/api/v1/cupones")
public class CuponController {

    @Autowired
    private CuponService service;

    @Operation(summary = "Obtiene todo los detalles de los cupones")
    @GetMapping
    public ResponseEntity<List<Cupon>> listar() {
        List<Cupon> cupones = service.getCupones();
        if (cupones.isEmpty())
            return ResponseEntity.noContent().build();          // 204
        return ResponseEntity.ok(cupones);                      // 200
    }

    @Operation(summary = "Obtiene todo los detalles de un cupon en específico, por id")
    @GetMapping("/{id}")
    public EntityModel<Cupon> buscarPorId(@PathVariable Integer id) {
        Cupon cupon = service.getCupon(id).orElseThrow();

        EntityModel<Cupon> model = EntityModel.of(cupon);

        model.add(
                linkTo(
                        methodOn(CuponController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(CuponController.class).listar()
                ).withRel("Todos-los-cupones")
        );

        return model;

//        Optional<Cupon> cupon = service.getCupon(id);
//        if (cupon.isPresent())
//            return ResponseEntity.ok(cupon.get());              // 200
//        return ResponseEntity.notFound().build();               // 404
    }

    @Operation(summary = "Obtiene todo los detalles de un cupon en específico, por codigo")
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Cupon> buscarPorCodigo(@PathVariable String codigo) {
        Optional<Cupon> cupon = service.getCuponByCodigo(codigo);
        if (cupon.isPresent())
            return ResponseEntity.ok(cupon.get());              // 200
        return ResponseEntity.notFound().build();               // 404
    }

    @Operation(summary = "Crea un nuevo cupon")
    @PostMapping
    public ResponseEntity<Cupon> agregar( @RequestBody Cupon cupon) {
        Cupon nuevo = service.saveCupon(cupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo); // 201
    }

    @Operation(summary = "Modifica el detalle de un cupon en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Cupon> editar(
            @PathVariable Integer id,
            @RequestBody Cupon cupon) {
        try {
            Cupon actualizado = service.updateCupon(id, cupon);
            return ResponseEntity.ok(actualizado);              // 200
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();           // 404
        }
    }

    @Operation(summary = "Borra un cupon en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteCupon(id);
            return ResponseEntity.noContent().build();          // 204
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();           // 404
        }
    }

    @Operation(summary = "Obtiene todo los detalles de los cupones disponibles")
    @GetMapping("/disponibles")
    public ResponseEntity<List<Cupon>> listarDisponibles() {
        List<Cupon> cupones = service.getCuponesDisponibles();
        if (cupones.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cupones);
    }

    @Operation(summary = "Obtiene todo los detalles de los cupones vigentes")
    @GetMapping("/vigentes")
    public ResponseEntity<List<Cupon>> listarVigentes() {
        List<Cupon> cupones = service.getCuponesVigentes();
        if (cupones.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cupones);
    }
}
