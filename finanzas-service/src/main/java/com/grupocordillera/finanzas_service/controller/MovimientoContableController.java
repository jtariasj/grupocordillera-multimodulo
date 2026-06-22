package com.grupocordillera.finanzas_service.controller;

import com.grupocordillera.finanzas_service.model.MovimientoContable;
import com.grupocordillera.finanzas_service.service.MovimientoContableService;
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

@Tag(name = "Movimientos contables", description = "Operaciones relacionadas con los movimientos contables")
@RestController
@RequestMapping("/api/v1/movimientos")
public class MovimientoContableController {

    @Autowired
    private MovimientoContableService service;

    @Operation(summary = "Obtiene todo los detalles de los movimientos contables")
    @GetMapping
    public ResponseEntity<List<MovimientoContable>> listar() {
        List<MovimientoContable> movimientos = service.getMovimientos();
        if (movimientos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(movimientos);
    }

    @Operation(summary = "Obtiene todo los detalles de un movimiento contable en específico")
    @GetMapping("/{id}")
    public EntityModel<MovimientoContable> buscarPorId(@PathVariable Integer id) {

        MovimientoContable movimientoContable = service.getMovimiento(id).orElseThrow();

        EntityModel<MovimientoContable> model = EntityModel.of(movimientoContable);

        model.add(
                linkTo(
                        methodOn(MovimientoContableController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(MovimientoContableController.class).listar()
                ).withRel("Todos-los-movimientos-contables")
        );

        return model;

//        Optional<MovimientoContable> movimiento = service.getMovimiento(id);
//        if (movimiento.isPresent()) return ResponseEntity.ok(movimiento.get());
//        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crea un nuevo movimiento contable")
    @PostMapping
    public ResponseEntity<MovimientoContable> agregar( @RequestBody MovimientoContable movimiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMovimiento(movimiento));
    }

    @Operation(summary = "Modifica el detalle de un movimiento contable en específico")
    @PutMapping("/{id}")
    public ResponseEntity<MovimientoContable> editar(@PathVariable Integer id, @RequestBody MovimientoContable movimiento) {
        try {
            return ResponseEntity.ok(service.updateMovimiento(id, movimiento));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Borra un movimiento contable en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteMovimiento(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene todo los detalles de los movimientos contables de ingresos")
    @GetMapping("/ingresos")
    public ResponseEntity<List<MovimientoContable>> listarIngresos() {
        List<MovimientoContable> ingresos = service.getIngresos();
        if (ingresos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ingresos);
    }

    @Operation(summary = "Obtiene todo los detalles de los movimientos contables de egresos")
    @GetMapping("/egresos")
    public ResponseEntity<List<MovimientoContable>> listarEgresos() {
        List<MovimientoContable> egresos = service.getEgresos();
        if (egresos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(egresos);
    }
}
