package com.grupocordillera.descuentos_service.controller;

import com.grupocordillera.descuentos_service.model.ReglaDescuento;
import com.grupocordillera.descuentos_service.service.ReglaDescuentoService;
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

@Tag(name = "Reglas", description = "Operaciones relacionadas con las reglas")
@RestController
@RequestMapping("/api/v1/reglas")
public class ReglaDescuentoController {

    @Autowired
    private ReglaDescuentoService service;

    @Operation(summary = "Obtiene todo los detalles de las reglas")
    @GetMapping
    public ResponseEntity<List<ReglaDescuento>> listar() {
        List<ReglaDescuento> reglas = service.getReglas();
        if (reglas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reglas);
    }

    @Operation(summary = "Obtiene todo los detalles de una regla en específico")
    @GetMapping("/{id}")
    public EntityModel<ReglaDescuento> buscarPorId(@PathVariable Integer id) {
        ReglaDescuento reglaDescuento = service.getRegla(id).orElseThrow();

        EntityModel<ReglaDescuento> model = EntityModel.of(reglaDescuento);

        model.add(
                linkTo(
                        methodOn(ReglaDescuentoController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(ReglaDescuentoController.class).listar()
                ).withRel("Todas-las-reglas-descuento")
        );

        return model;

//        Optional<ReglaDescuento> regla = service.getRegla(id);
//        if (regla.isPresent())
//            return ResponseEntity.ok(regla.get());
//        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crea una nueva regla")
    @PostMapping
    public ResponseEntity<ReglaDescuento> agregar(@RequestBody ReglaDescuento regla) {
        ReglaDescuento nueva = service.saveRegla(regla);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @Operation(summary = "Modifica el detalle de una regla en específico")
    @PutMapping("/{id}")
    public ResponseEntity<ReglaDescuento> editar(
            @PathVariable Integer id,
            @RequestBody ReglaDescuento regla) {
        try {
            ReglaDescuento actualizada = service.updateRegla(id, regla);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Borra una regla en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteRegla(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene todo los detalles de las reglas por campaña")
    @GetMapping("/campana/{idCampana}")
    public ResponseEntity<List<ReglaDescuento>> listarPorCampana(@PathVariable Integer idCampana) {
        List<ReglaDescuento> reglas = service.getReglasByCampana(idCampana);
        if (reglas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reglas);
    }

    @Operation(summary = "Obtiene todo los detalles de las reglas activas")
    @GetMapping("/activas")
    public ResponseEntity<List<ReglaDescuento>> listarActivasOrdenadas() {
        List<ReglaDescuento> reglas = service.getReglasActivasOrdenadas();
        if (reglas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reglas);
    }
}
