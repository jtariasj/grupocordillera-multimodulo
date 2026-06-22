package com.grupocordillera.seguridad_service.controller;
import com.grupocordillera.seguridad_service.model.Roles;
import com.grupocordillera.seguridad_service.service.RolesService;
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

@Tag(name = "Roles", description = "Operaciones relacionadas con los roles")
@RestController
@RequestMapping("api/v1/roles") // Endpoint principal
public class RolesController {
    @Autowired
    private RolesService service;

    @Operation(summary = "Obtiene todo los detalles de los roles")
    @GetMapping
    public ResponseEntity<List<Roles>> listar() {
        List<Roles> roles = service.getRoles();
        if (roles.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(roles);
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un rol en específico")
    @GetMapping("/{id}")
    public EntityModel<Roles> buscar(@PathVariable Integer id) {

        Roles rol = service.getRol(id).orElseThrow();

        EntityModel<Roles> model = EntityModel.of(rol);

        model.add(
                linkTo(
                        methodOn(RolesController.class).buscar(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(RolesController.class).listar()
                ).withRel("Todos-los-roles")
        );

        return model;

//        Optional<Roles> rol = service.getRol(id);
//
//        if (rol.isPresent()) {
//            return ResponseEntity.ok(rol.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @Operation(summary = "Crea un nuevo rol")
    @PostMapping
    public ResponseEntity<Roles> agregar(@RequestBody Roles rol) {
        Roles nuevoRol = service.saveRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    @Operation(summary = "Modifica el detalle de un rol en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Roles> editar(@PathVariable Integer id, @RequestBody Roles rol) {
        Optional<Roles> existe = service.getRol(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
        rol.setIdRol(id);
        Roles actualizado = service.saveRol(rol);
        return ResponseEntity.ok(actualizado);}
    }

    @Operation(summary = "Borra un rol en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteRol(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
