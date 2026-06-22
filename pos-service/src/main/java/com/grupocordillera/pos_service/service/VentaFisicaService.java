package com.grupocordillera.pos_service.service;

import com.grupocordillera.pos_service.client.SucursalClient;
import com.grupocordillera.pos_service.dto.SucursalDTO;
import com.grupocordillera.pos_service.dto.VentaSucursalDTO;
import com.grupocordillera.pos_service.model.VentaFisica;
import com.grupocordillera.pos_service.repository.VentaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaFisicaService {

    @Autowired
    private VentaFisicaRepository repository;

    public List<VentaFisica> getVentas() {
        return repository.findAll();
    }

    public Optional<VentaFisica> getVenta(Integer id) {
        return repository.findById(id);
    }

    public VentaFisica saveVenta(VentaFisica venta) {
        return repository.save(venta);
    }

    public VentaFisica updateVenta(Integer id, VentaFisica venta) {
        if (!repository.existsById(id))
            throw new RuntimeException("Venta no encontrada con id: " + id);
        venta.setId(id);
        return repository.save(venta);
    }

    public void deleteVenta(Integer id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Venta no encontrada con id: " + id);
        repository.deleteById(id);
    }

    public List<VentaFisica> getVentasActivas() {
        return repository.findVentasActivas();
    }

    public List<VentaFisica> getVentasCompletadas() {
        return repository.findVentasCompletadas();
    }

    @Autowired
    private SucursalClient sucursalClient;

    public VentaSucursalDTO getVentaConSucursal(Integer idVenta, Integer idSucursal) {

        VentaFisica venta =
                repository.findById(idVenta).orElse(null);

        SucursalDTO sucursal =
                sucursalClient.obtenerSucursal(idSucursal);

        VentaSucursalDTO dto =
                new VentaSucursalDTO();

        dto.setIdVenta(venta.getId());
        dto.setSucursal(sucursal);
        dto.setNumeroBoleta(venta.getNumeroBoleta());
        dto.setFechaVenta(venta.getFechaVenta());
        dto.setTotal(venta.getTotal());

        return dto;
    }

}
