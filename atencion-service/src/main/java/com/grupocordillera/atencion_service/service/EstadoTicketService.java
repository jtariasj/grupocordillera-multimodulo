package com.grupocordillera.atencion_service.service;

import com.grupocordillera.atencion_service.model.EstadoTicket;
import com.grupocordillera.atencion_service.repository.EstadoTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoTicketService {

    @Autowired
    private EstadoTicketRepository estadoTicketRepository;

    public List<EstadoTicket> getEstados(){ return estadoTicketRepository.findAll();}

    public Optional<EstadoTicket> getEstado(Integer id){ return estadoTicketRepository.findById(id);}

    public EstadoTicket saveEstado(EstadoTicket estadoTicket){ return estadoTicketRepository.save(estadoTicket);}

    public EstadoTicket updateEstado(Integer id, EstadoTicket estadoTicket) {
        Optional existe = getEstado(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("No encontrado");
        } else {
            return estadoTicketRepository.save(estadoTicket);
        }
    }

    public void deleteProducto(Integer id){
        if(estadoTicketRepository.existsById(id)){
            estadoTicketRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("No encontrado");
        }
    }
}
