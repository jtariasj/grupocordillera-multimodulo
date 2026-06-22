package com.grupocordillera.finanzas_service.controller;

import com.grupocordillera.finanzas_service.model.MetodoPago;
import com.grupocordillera.finanzas_service.service.MetodoPagoService;
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

@Tag(name = "Metodos de pago", description = "Operaciones relacionadas con los metodos de pago")
@RestController
@RequestMapping("/api/v1/metodos-pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService service;

    @Operation(summary = "Obtiene todo los detalles de los metodos de pago")
    @GetMapping
    public ResponseEntity<List<MetodoPago>> listar() {
        List<MetodoPago> metodos = service.getMetodos();
        if (metodos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(metodos);
    }

    @Operation(summary = "Obtiene todo los detalles de un metodo de pago en específico")
    @GetMapping("/{id}")
    public EntityModel<MetodoPago> buscarPorId(@PathVariable Integer id) {

        MetodoPago metodoPago = service.getMetodo(id).orElseThrow();

        EntityModel<MetodoPago> model = EntityModel.of(metodoPago);

        model.add(
                linkTo(
                        methodOn(MetodoPagoController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(MetodoPagoController.class).listar()
                ).withRel("Todos-los-metodos-de-pago")
        );

        return model;

//        Optional<MetodoPago> metodo = service.getMetodo(id);
//        if (metodo.isPresent()) return ResponseEntity.ok(metodo.get());
//        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crea un nuevo metodo de pago")
    @PostMapping
    public ResponseEntity<MetodoPago> agregar( @RequestBody MetodoPago metodo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMetodo(metodo));
    }

    @Operation(summary = "Modifica el detalle de un metodo de pago en específico")
    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> editar(@PathVariable Integer id,  @RequestBody MetodoPago metodo) {
        try {
            return ResponseEntity.ok(service.updateMetodo(id, metodo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Borra un metodo de pago en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteMetodo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene el detalle de los metodos de pago activos")
    @GetMapping("/activos")
    public ResponseEntity<List<MetodoPago>> listarActivos() {
        List<MetodoPago> metodos = service.getMetodosActivos();
        if (metodos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(metodos);
    }
}
