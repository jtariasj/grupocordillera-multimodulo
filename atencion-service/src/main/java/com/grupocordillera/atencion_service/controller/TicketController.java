package com.grupocordillera.atencion_service.controller;

import com.grupocordillera.atencion_service.dto.TicketClienteDTO;
import com.grupocordillera.atencion_service.model.Ticket;
import com.grupocordillera.atencion_service.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Tickets", description = "Operaciones relacionadas con los tickets")
@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Operation(summary = "Obtiene todo los detalles de los tickets")
    @GetMapping
    public ResponseEntity<List<Ticket>> getTickets(){
        List<Ticket> tickets = ticketService.getTickets();

        if(tickets.isEmpty()){
            return ResponseEntity.noContent().build();  //204
        }
        else{
            return ResponseEntity.ok(tickets); //200
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un ticket en específico")
    @GetMapping("/{id}")
    public EntityModel<Ticket> getTicket(@PathVariable Integer id){
        Ticket ticket = ticketService.getTicket(id).orElseThrow();

        EntityModel<Ticket> model = EntityModel.of(ticket);

        model.add(
                linkTo(
                        methodOn(TicketController.class).getTicket(id)     //obtiene la clase ticket y además todos los métodos que hacen referencia a la clase
                ).withSelfRel()
        );

//        model.add(
//                Link.of("http://localhost:8084" +
//                        "/api/v1/tickets/" + id, "eliminar")   //este metodo no es get, asi que no debería ser agregado
//        );

        model.add(
                linkTo(
                        methodOn(TicketController.class).getTickets()
                ).withRel("Todos-los-tickets")
        );

        return model;

    //public ResponseEntity<Ticket> buscarPorId(@PathVariable Integer id){
//        Optional<Ticket> ticket = ticketService.getTicket(id);
//
//        return ticket
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());          //buena práctica tener los 2 metodos, el que entra toda la información y este


    }

    @Operation(summary = "Crea un nuevo ticket")
    @PostMapping
    public ResponseEntity<Ticket> agregarTicket(@RequestBody Ticket ticket){
        Ticket nuevoTicket = ticketService.saveTicket(ticket);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoTicket);
    }

    @Operation(summary = "Modifica el detalle de un ticket en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> editar(@PathVariable Integer id, @RequestBody Ticket ticket){
        Optional<Ticket> existe = ticketService.getTicket(id);

        if (existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            ticket.setId(id);
            Ticket actualizado = ticketService.saveTicket(ticket);
            return ResponseEntity.ok(actualizado);
        }
    }

    @Operation(summary = "Borra un ticket en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            ticketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene un ticket y junto a un cliente relacionado")
    @GetMapping("{id1}/clientes/{id2}")
    public TicketClienteDTO getTicketConCliente(@PathVariable Integer id1, @PathVariable Integer id2) {
        return ticketService.getTicketConCliente(id1, id2);
    }

}
