package com.grupocordillera.ecommerce_service.controller;

import com.grupocordillera.ecommerce_service.dto.PedidoMetodoPagoDTO;
import com.grupocordillera.ecommerce_service.model.PedidoOnline;
import com.grupocordillera.ecommerce_service.repository.PedidoOnlineRepository;
import com.grupocordillera.ecommerce_service.service.PedidoOnlineService;
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

@Tag(name = "Pedidos", description = "Operaciones relacionadas con los pedidos")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoOnlineController {

    @Autowired
    private PedidoOnlineService service;
    @Autowired
    private PedidoOnlineRepository pedidoOnlineRepository;

    @Operation(summary = "Obtiene todo los detalles de los pedidos")
    @GetMapping
    public ResponseEntity<List<PedidoOnline>> listar() {
        List<PedidoOnline> pedidos = service.getPedidos();
        if (pedidos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pedidos);
    }

    @Operation(summary = "Obtiene todo los detalles de un pedido en específico")
    @GetMapping("/{id}")
    public EntityModel<PedidoOnline> buscarPorId(@PathVariable Integer id) {

        PedidoOnline pedidoOnline = service.getPedido(id).orElseThrow();

        EntityModel<PedidoOnline> model = EntityModel.of(pedidoOnline);

        model.add(
                linkTo(
                        methodOn(PedidoOnlineController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(PedidoOnlineController.class).listar()
                ).withRel("Todos-los-pedidos")
        );

        return model;

//        Optional<PedidoOnline> pedido = service.getPedido(id);
//        if (pedido.isPresent()) return ResponseEntity.ok(pedido.get());
//        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crea un nuevo pedido")
    @PostMapping
    public ResponseEntity<PedidoOnline> agregar( @RequestBody PedidoOnline pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePedido(pedido));
    }

    @Operation(summary = "Modifica el detalle de un pedido en específico")
    @PutMapping("/{id}")
    public ResponseEntity<PedidoOnline> editar(@PathVariable Integer id, @RequestBody PedidoOnline pedido) {
        try {
            return ResponseEntity.ok(service.updatePedido(id, pedido));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Borra un pedido en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deletePedido(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene el detalle de los pedidos pendientes")
    @GetMapping("/pendientes")
    public ResponseEntity<List<PedidoOnline>> listarPendientes() {
        List<PedidoOnline> pedidos = service.getPedidosPendientes();
        if (pedidos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pedidos);
    }

    @Operation(summary = "Obtiene un pedido y junto a un metodo de pago relacionado")
    @GetMapping("{id1}/metodos/{id2}")
    public PedidoMetodoPagoDTO getPedidoConMetodo(@PathVariable Integer id1, @PathVariable Integer id2) {
        return service.getPedidoConMetodo(id1, id2);
    }
}
