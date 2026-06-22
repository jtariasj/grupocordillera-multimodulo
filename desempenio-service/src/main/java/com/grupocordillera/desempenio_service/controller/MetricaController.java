package com.grupocordillera.desempenio_service.controller;

import com.grupocordillera.desempenio_service.dto.MetricaSucursalDTO;
import com.grupocordillera.desempenio_service.model.Metrica;
import com.grupocordillera.desempenio_service.service.MetricaService;
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

@Tag(name = "Metricas", description = "Operaciones relacionadas con las metricas")
@RestController
@RequestMapping("api/v1/metricas")
public class MetricaController {
    @Autowired
    private MetricaService service;

    @Operation(summary = "Obtiene todo los detalles de las metricas")
    @GetMapping
    public ResponseEntity<List<Metrica>> listar() {
        List<Metrica> metricas = service.getMetricas();
        if (metricas.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(metricas);
        }
    }

    @Operation(summary = "Obtiene todo los detalles de una metrica en específico")
    @GetMapping("/{id}")
    public EntityModel<Metrica> buscar(@PathVariable Integer id) {
        Metrica metrica = service.getMetrica(id).orElseThrow();

        EntityModel<Metrica> model = EntityModel.of(metrica);

        model.add(
                linkTo(
                        methodOn(MetricaController.class).buscar(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(MetricaController.class).listar()
                ).withRel("Todas-las-metricas")
        );

        return model;

//        Optional<Metrica> metrica = service.getMetrica(id);
//
//        if (metrica.isPresent()) {
//            return ResponseEntity.ok(metrica.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @Operation(summary = "Crea una nueva metrica")
    @PostMapping
    public ResponseEntity<Metrica> agregar(@RequestBody Metrica metrica) {
        Metrica nuevaMetrica = service.saveMetrica(metrica);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMetrica);
    }

    @Operation(summary = "Modifica el detalle de una metrica en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Metrica> editar(@PathVariable Integer id, @RequestBody Metrica metrica) {
        Optional<Metrica> existe = service.getMetrica(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        metrica.setId(id);
        Metrica actualizado = service.saveMetrica(metrica);
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "Borra una metrica en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteMetrica(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene una metrica y junto a una sucursal relacionada")
    @GetMapping("{id1}/sucursales/{id2}")
    public MetricaSucursalDTO getMetricaConSucursal(@PathVariable Integer id1, @PathVariable Integer id2) {
        return service.getMetricaConSucursal(id1, id2);
    }
}

