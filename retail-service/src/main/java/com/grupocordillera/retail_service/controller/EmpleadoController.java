package com.grupocordillera.retail_service.controller;

import com.grupocordillera.retail_service.model.Empleado;
import com.grupocordillera.retail_service.service.EmpleadoService;
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

@Tag(name = "Empleados", description = "Operaciones relacionadas con los empleados")
@RestController
@RequestMapping("api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @Operation(summary = "Obtiene todo los detalles de los empleados")
    @GetMapping
    public ResponseEntity<List<Empleado>> listar(){
        List<Empleado> empleados = service.getEmpleados();

        if(empleados.isEmpty()){
            return ResponseEntity.noContent().build(); // 204
        }
        else{
            return ResponseEntity.ok(empleados); // 200
        }
    }

    @Operation(summary = "Obtiene todo los detalles de un empleado en específico")
    @GetMapping("/{id}")
    public EntityModel<Empleado> buscarPorId(@PathVariable Integer id){

        Empleado empleado = service.getEmpleado(id).orElseThrow();

        EntityModel<Empleado> model = EntityModel.of(empleado);

        model.add(
                linkTo(
                        methodOn(EmpleadoController.class).buscarPorId(id)
                ).withSelfRel()
        );

        model.add(
                linkTo(
                        methodOn(EmpleadoController.class).listar()
                ).withRel("Todos-los-empleados")
        );

        return model;

//        Optional<Empleado> empleado = service.getEmpleado(id);
//
//        return empleado
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea un nuevo empleado")
    @PostMapping
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado){
        Empleado nuevoEmpleado = service.saveEmpleado(empleado);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .body(nuevoEmpleado);
    }

    @Operation(summary = "Modifica el detalle de un empleado en específico")
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> editar(@PathVariable Integer id, @RequestBody Empleado empleado){
        Optional<Empleado> existe = service.getEmpleado(id);

        if(existe.isEmpty()){
            return ResponseEntity.notFound().build(); // 404
        }
        else{
            empleado.setId(id);

            Empleado actualizado = service.saveEmpleado(empleado);
            return ResponseEntity.ok(actualizado); // 200
        }
    }

    @Operation(summary = "Borra un empleado en específico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        try{
            service.deleteEmpleado(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
