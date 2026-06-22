package com.grupocordillera.ecommerce_service.service;

import com.grupocordillera.ecommerce_service.model.ClienteDigital;
import com.grupocordillera.ecommerce_service.repository.ClienteDigitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteDigitalService {

    @Autowired
    private ClienteDigitalRepository repository;

    public List<ClienteDigital> getClientes() {
        return repository.findAll();
    }

    public Optional<ClienteDigital> getCliente(Integer id) {
        return repository.findById(id);
    }

    public ClienteDigital saveCliente(ClienteDigital cliente) {
        return repository.save(cliente);
    }

    public ClienteDigital updateCliente(Integer id, ClienteDigital cliente) {
        if (!repository.existsById(id))
            throw new RuntimeException("Cliente no encontrado con id: " + id);
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void deleteCliente(Integer id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Cliente no encontrado con id: " + id);
        repository.deleteById(id);
    }

    public List<ClienteDigital> getClientesActivos() {
        return repository.findClientesActivos();
    }
}
