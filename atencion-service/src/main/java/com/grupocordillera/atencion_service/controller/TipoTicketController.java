package com.grupocordillera.atencion_service.controller;

import com.grupocordillera.atencion_service.model.TipoTicket;
import com.grupocordillera.atencion_service.service.TipoTicketService;
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

@Tag(name = "Tipo ticket", description = "Operaciones relacionadas con los tipos de tickets")
@RestController
@RequestMapping("api/v1/tipo-tickets")
public class TipoTicketController {

    @Autowired
    private TipoTicketService tipoTicketService;

    @Operation(summary = "Obtiene todo los detalles de los tipos de tickets")
    @GetMapping
    public ResponseEntity<List<TipoTicket>> listar(){
        List<TipoTicket> tipoTickets = tipoTicketService.getTipos();

        if(tipoTickets.isEmpty()){
            return ResponseEntity.noContent().build();  //204
        }
        else{
            return ResponseEntity.ok(tipoTickets); //200
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un tipo de ticket en específico")
    @GetMapping("/{id}")
    public EntityModel<TipoTicket> buscarPorId(@PathVariable Integer id){
        TipoTicket tipoTicket = tipoTicketService.getTipo(id).orElseThrow();

        EntityModel<TipoTicket> model = EntityModel.of(tipoTicket);

        model.add(
                linkTo(
                        methodOn(TipoTicketController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(TipoTicketController.class).listar()
                ).withRel("Todos-los-tipo-tickets")
        );

        return model;

//        Optional<TipoTicket> tipoTicket = tipoTicketService.getTipo(id);
//
//        return tipoTicket
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea un nuevo tipo de ticket")
    @PostMapping
    public ResponseEntity<TipoTicket> agregarTipo(@RequestBody TipoTicket tipoTicket){
        TipoTicket nuevoTipo = tipoTicketService.saveTipo(tipoTicket);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoTipo);
    }

    @Operation(summary = "Modifica el detalle de un tipo de ticket en específico")
    @PutMapping("/{id}")
    public ResponseEntity<TipoTicket> editar(@PathVariable Integer id, @RequestBody TipoTicket tipoTicket){
        Optional<TipoTicket> existe = tipoTicketService.getTipo(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            tipoTicket.setId(id);
            TipoTicket actualizado = tipoTicketService.saveTipo(tipoTicket);
            return ResponseEntity.ok(actualizado);
        }
    }

    @Operation(summary = "Borra un tipo de ticket en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            tipoTicketService.deleteTipo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
