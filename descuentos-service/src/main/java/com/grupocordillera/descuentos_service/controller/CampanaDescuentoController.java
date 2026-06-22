package com.grupocordillera.descuentos_service.controller;

import com.grupocordillera.descuentos_service.client.RetailClient;
import com.grupocordillera.descuentos_service.dto.MetodoPagoDTO;
import com.grupocordillera.descuentos_service.model.CampanaDescuento;
import com.grupocordillera.descuentos_service.service.CampanaDescuentoService;
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

@Tag(name = "Campañas", description = "Operaciones relacionadas con las campañas")
@RestController
@RequestMapping("/api/v1/campanas")
public class CampanaDescuentoController {

    @Autowired
    private CampanaDescuentoService service;

    @Autowired
    private RetailClient retailClient;

    @Operation(summary = "Obtiene todo los detalles de las campañas")
    @GetMapping
    public ResponseEntity<List<CampanaDescuento>> listar() {
        List<CampanaDescuento> campanas = service.getCampanas();
        if (campanas.isEmpty())
            return ResponseEntity.noContent().build();          // 204
        return ResponseEntity.ok(campanas);                     // 200
    }

    @Operation(summary = "Obtiene todo los detalles de una campaña en específico")
    @GetMapping("/{id}")
    public EntityModel<CampanaDescuento> buscarPorId(@PathVariable Integer id) {
        CampanaDescuento campanaDescuento = service.getCampana(id).orElseThrow();

        EntityModel<CampanaDescuento> model = EntityModel.of(campanaDescuento);

        model.add(
                linkTo(
                        methodOn(CampanaDescuentoController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(CampanaDescuentoController.class).listar()
                ).withRel("Todas-las-campañas-descuento")
        );

        return model;

//        Optional<CampanaDescuento> campana = service.getCampana(id);
//        if (campana.isPresent())
//            return ResponseEntity.ok(campana.get());            // 200
//        return ResponseEntity.notFound().build();               // 404
    }

    @Operation(summary = "Crea una nueva campaña")
    @PostMapping
    public ResponseEntity<CampanaDescuento> agregar( @RequestBody CampanaDescuento campana) {
        CampanaDescuento nueva = service.saveCampana(campana);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva); // 201
    }

    @Operation(summary = "Modifica el detalle de una campaña en específico")
    @PutMapping("/{id}")
    public ResponseEntity<CampanaDescuento> editar(
            @PathVariable Integer id,
            @RequestBody CampanaDescuento campana) {
        try {
            CampanaDescuento actualizada = service.updateCampana(id, campana);
            return ResponseEntity.ok(actualizada);              // 200
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();           // 404
        }
    }

    @Operation(summary = "Borra una campaña en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteCampana(id);
            return ResponseEntity.noContent().build();          // 204
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();           // 404
        }
    }

    @Operation(summary = "Obtiene todo los detalles de las campañas activas")
    @GetMapping("/activas")
    public ResponseEntity<List<CampanaDescuento>> listarActivas() {
        List<CampanaDescuento> campanas = service.getCampanasActivas();
        if (campanas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(campanas);
    }

    @Operation(summary = "Obtiene todo los detalles de las campañas por canal")
    @GetMapping("/canal/{canal}")
    public ResponseEntity<List<CampanaDescuento>> listarPorCanal(
            @PathVariable CampanaDescuento.Canal canal) {
        List<CampanaDescuento> campanas = service.getCampanasByCanal(canal);
        if (campanas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(campanas);
    }

}
