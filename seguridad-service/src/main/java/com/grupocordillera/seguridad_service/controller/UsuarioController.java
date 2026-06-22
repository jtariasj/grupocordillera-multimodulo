package com.grupocordillera.seguridad_service.controller;

import com.grupocordillera.seguridad_service.model.Usuario;
import com.grupocordillera.seguridad_service.service.UsuarioService;
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

@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios")
@RestController
@RequestMapping("api/v1/usuarios") // Endpoint principal
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @Operation(summary = "Obtiene todo los detalles de los usuarios")
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = service.getUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuarios);
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un usuario en específico")
    @GetMapping("/{id}")
    public EntityModel<Usuario> buscar(@PathVariable Integer id) {

        Usuario usuario = service.getUsuario(id).orElseThrow();

        EntityModel<Usuario> model = EntityModel.of(usuario);

        model.add(
                linkTo(
                        methodOn(UsuarioController.class).buscar(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(UsuarioController.class).listar()
                ).withRel("Todos-los-usuarios")
        );

        return model;

//        Optional<Usuario> usuario = service.getUsuario(id);
//
//        if (usuario.isPresent()) {
//            return ResponseEntity.ok(usuario.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @Operation(summary = "Crea un nuevo usuario")
    @PostMapping
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = service.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @Operation(summary = "Modifica el detalle de un usuario en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> existe = service.getUsuario(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
        usuario.setIdUsuario(id);
        Usuario actualizado = service.saveUsuario(usuario);
        return ResponseEntity.ok(actualizado);}
    }

    @Operation(summary = "Borra un usuario en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
