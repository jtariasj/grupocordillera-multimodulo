package com.grupocordillera.pos_service.controller;

import com.grupocordillera.pos_service.client.SucursalClient;
import com.grupocordillera.pos_service.dto.SucursalDTO;
import com.grupocordillera.pos_service.dto.VentaSucursalDTO;
import com.grupocordillera.pos_service.model.VentaFisica;
import com.grupocordillera.pos_service.service.VentaFisicaService;
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

@Tag(name = "Ventas", description = "Operaciones relacionadas con las ventas")
@RestController
@RequestMapping("/api/v1/ventas")
public class VentaFisicaController {

    @Autowired
    private VentaFisicaService service;
    @Autowired
    private SucursalClient sucursalClient;

    @Operation(summary = "Obtiene todo los detalles de las ventas")
    @GetMapping
    public ResponseEntity<List<VentaFisica>> listar() {
        List<VentaFisica> ventas = service.getVentas();
        if (ventas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ventas);
    }

    @Operation(summary = "Obtiene todo los detalles de una venta en específico")
    @GetMapping("/{id}")
    public EntityModel<VentaFisica> buscarPorId(@PathVariable Integer id) {

        VentaFisica ventaFisica = service.getVenta(id).orElseThrow();

        EntityModel<VentaFisica> model = EntityModel.of(ventaFisica);

        model.add(
                linkTo(
                        methodOn(VentaFisicaController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(VentaFisicaController.class).listar()
                ).withRel("Todas-las-ventas")
        );

        return model;

//        Optional<VentaFisica> venta = service.getVenta(id);
//        if (venta.isPresent()) return ResponseEntity.ok(venta.get());
//        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Crea una nueva venta")
    @PostMapping
    public ResponseEntity<VentaFisica> agregar(@RequestBody VentaFisica venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveVenta(venta));
    }

    @Operation(summary = "Modifica el detalle de una venta en específico")
    @PutMapping("/{id}")
    public ResponseEntity<VentaFisica> editar(@PathVariable Integer id, @RequestBody VentaFisica venta) {
        try {
            return ResponseEntity.ok(service.updateVenta(id, venta));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Borra una venta en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            service.deleteVenta(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtiene todo los detalles de las venta activas")
    @GetMapping("/activas")
    public ResponseEntity<List<VentaFisica>> listarActivas() {
        List<VentaFisica> ventas = service.getVentasActivas();
        if (ventas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ventas);
    }

    @Operation(summary = "Obtiene todo los detalles de las venta completadas")
    @GetMapping("/completadas")
    public ResponseEntity<List<VentaFisica>> listarCompletadas() {
        List<VentaFisica> ventas = service.getVentasCompletadas();
        if (ventas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(ventas);
    }

    @Operation(summary = "Obtiene una venta y junto a una sucursal relacionada")
    @GetMapping("{id1}/sucursales/{id2}")
    public VentaSucursalDTO getVentaConSucursal(@PathVariable Integer id1, @PathVariable Integer id2) {
        return service.getVentaConSucursal(id1, id2);
    }

}
