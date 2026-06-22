package com.grupocordillera.atencion_service.controller;

import com.grupocordillera.atencion_service.model.EstadoTicket;
import com.grupocordillera.atencion_service.service.EstadoTicketService;
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

@Tag(name = "Estado ticket", description = "Operaciones relacionadas con los estados de tickets")
@RestController
@RequestMapping("api/v1/estados")
public class EstadoTicketController {

    @Autowired
    private EstadoTicketService estadoTicketService;

    @Operation(summary = "Obtiene todo los detalles de los estados de tickets")
    @GetMapping
    public ResponseEntity<List<EstadoTicket>> listar(){
        List<EstadoTicket> estados = estadoTicketService.getEstados();

        if(estados.isEmpty()){
            return ResponseEntity.noContent().build();  //204
        }
        else{
            return ResponseEntity.ok(estados); //200
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un estado de ticket en específico")
    @GetMapping("/{id}")
    public EntityModel<EstadoTicket> buscarPorId(@PathVariable Integer id){
        EstadoTicket estadoTicket = estadoTicketService.getEstado(id).orElseThrow();

        EntityModel<EstadoTicket> model = EntityModel.of(estadoTicket);

        model.add(
                linkTo(
                        methodOn(EstadoTicketController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(EstadoTicketController.class).listar()
                ).withRel("Todos-los-estado-ticket")
        );

        return model;

//        Optional<EstadoTicket> estadoTicket = estadoTicketService.getEstado(id);
//
//        return estadoTicket
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea un nuevo estado de ticket")
    @PostMapping
    public ResponseEntity<EstadoTicket> agregarEstado(@RequestBody EstadoTicket estadoTicket){
        EstadoTicket nuevoEstado = estadoTicketService.saveEstado(estadoTicket);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoEstado);
    }

    @Operation(summary = "Modifica el detalle de un estado de ticket en específico")
    @PutMapping("/{id}")
    public ResponseEntity<EstadoTicket> editar(@PathVariable Integer id, @RequestBody EstadoTicket estadoTicket){
        Optional<EstadoTicket> existe = estadoTicketService.getEstado(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            estadoTicket.setId(id);
            EstadoTicket actualizado = estadoTicketService.saveEstado(estadoTicket);
            return ResponseEntity.ok(actualizado);
        }
    }

    @Operation(summary = "Borra un estado de ticket en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            estadoTicketService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
