package com.grupocordillera.retail_service.service;

import com.grupocordillera.retail_service.model.Empleado;
import com.grupocordillera.retail_service.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getEmpleados(){ return empleadoRepository.findAll();}

    public Optional<Empleado> getEmpleado(Integer id){ return empleadoRepository.findById(id);}

    public Empleado saveEmpleado(Empleado empleado){ return empleadoRepository.save(empleado);}

    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        Optional existe = getEmpleado(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("No encontrado");
        } else {
            return empleadoRepository.save(empleado);
        }
    }

    public void deleteEmpleado(Integer id){
        if(empleadoRepository.existsById(id)){
            empleadoRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("No encontrado");
        }
    }
}

