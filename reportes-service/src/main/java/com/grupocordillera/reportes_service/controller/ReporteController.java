package com.grupocordillera.reportes_service.controller;

import com.grupocordillera.reportes_service.client.UsuarioClient;
import com.grupocordillera.reportes_service.dto.UsuarioDTO;
import com.grupocordillera.reportes_service.model.Reporte;
import com.grupocordillera.reportes_service.service.ReporteService;
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

@Tag(name = "Reportes", description = "Operaciones relacionadas con los reportes")
@RestController
@RequestMapping("api/v1/reportes")
public class ReporteController {
    @Autowired
    private ReporteService service;
    @Autowired
    private UsuarioClient usuarioClient;

    @Operation(summary = "Obtiene todo los detalles de los reportes")
    @GetMapping
    public ResponseEntity<List<Reporte>> listar() {
        List<Reporte> reportes = service.getReportes();
        if (reportes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(reportes);
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un reporte en específico")
    @GetMapping("/{id}")
    public EntityModel<Reporte> buscar(@PathVariable Integer id) {

        Reporte reporte = service.getReporte(id).orElseThrow();

        EntityModel<Reporte> model = EntityModel.of(reporte);

        model.add(
                linkTo(
                        methodOn(ReporteController.class).buscar(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(ReporteController.class).listar()
                ).withRel("Todos-los-reportes")
        );

        return model;

//        Optional<Reporte> reporte = service.getReporte(id);
//
//        if (reporte.isPresent()) {
//            return ResponseEntity.ok(reporte.get()); //201 ok
//        } else {
//            return ResponseEntity.notFound().build(); //204 no content
//        }
    }

    @Operation(summary = "Crea un nuevo reporte")
    @PostMapping
    public ResponseEntity<Reporte> agregar(@RequestBody Reporte reporte) {
        Reporte nuevoReporte = service.saveReporte(reporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReporte);
    }

    @Operation(summary = "Modifica el detalle de un reporte en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Reporte> editar(@PathVariable Integer id, @RequestBody Reporte reporte) {
        Optional<Reporte> existe = service.getReporte(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Reporte actualizado = service.saveReporte(reporte);
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "Borra un reporte en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteReporte(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene un reporte y junto a un usuario relacionado")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDTO> listarUsuarioPorId(@PathVariable Integer id) {
        UsuarioDTO usuario = usuarioClient.obtenerUsuarioPorId(id);
        if(usuario != null) {
            return ResponseEntity.ok(usuario); //Se encontro el propietario
        } else {
            return ResponseEntity.notFound().build(); //404 no encontrado
        }
    }

}