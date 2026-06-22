package com.grupocordillera.retail_service.service;

import com.grupocordillera.retail_service.model.Sucursal;
import com.grupocordillera.retail_service.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> getSucursales(){ return sucursalRepository.findAll();}

    public Optional<Sucursal> getSucursal(Integer id){ return sucursalRepository.findById(id);}

    public Sucursal saveSucursal(Sucursal sucursal){ return sucursalRepository.save(sucursal);}

    public Sucursal updateSucursal(Integer id, Sucursal sucursal) {
        Optional existe = getSucursal(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("No encontrado");
        } else {
            return sucursalRepository.save(sucursal);
        }
    }

    public void deleteSucursal(Integer id){
        if(sucursalRepository.existsById(id)){
            sucursalRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("No encontrado");
        }
    }
}
