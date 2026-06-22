package com.grupocordillera.ecommerce_service.controller;

import com.grupocordillera.ecommerce_service.model.ClienteDigital;
import com.grupocordillera.ecommerce_service.service.ClienteDigitalService;
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

@Tag(name = "Clientes", description = "Operaciones relacionadas con los clientes")
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteDigitalController {

    @Autowired
    private ClienteDigitalService service;

    @Operation(summary = "Obtiene todo los detalles de los clientes")
    @GetMapping
    public ResponseEntity<List<ClienteDigital>> listar() {
        List<ClienteDigital> clientes = service.getClientes();
        if (clientes.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Obtiene todo los detalles de un cliente en específico")
    @GetMapping("/{id}")
    public EntityModel<ClienteDigital> buscarPorId(@PathVariable Integer id) {

        ClienteDigital clienteDigital = service.getCliente(id).orElseThrow();

        EntityModel<ClienteDigital> model = EntityModel.of(clienteDigital);

        model.add(
                linkTo(
                        methodOn(ClienteDigitalController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(ClienteDigitalController.class).listar()
                ).withRel("Todos-los-clientes")
        );

        return model;
//        Optional<ClienteDigital> cliente = service.getCliente(id);
//        if (cliente.isPresent()) return ResponseEntity.ok(cliente.get());
//        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crea un nuevo cliente")
    @PostMapping
    public ResponseEntity<ClienteDigital> agregar( @RequestBody ClienteDigital cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCliente(cliente));
    }

    @Operation(summary = "Modifica el detalle de un cliente en específico")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDigital> editar(@PathVariable Integer id, @RequestBody ClienteDigital cliente) {
        try {
            return ResponseEntity.ok(service.updateCliente(id, cliente));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Borra un cliente en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteCliente(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene el detalle de los clientes activos")
    @GetMapping("/activos")
    public ResponseEntity<List<ClienteDigital>> listarActivos() {
        List<ClienteDigital> clientes = service.getClientesActivos();
        if (clientes.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clientes);
    }
}
