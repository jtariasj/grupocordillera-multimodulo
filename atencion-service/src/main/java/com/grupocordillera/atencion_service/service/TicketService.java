package com.grupocordillera.atencion_service.service;

import com.grupocordillera.atencion_service.client.ClienteClient;
import com.grupocordillera.atencion_service.dto.ClienteDTO;
import com.grupocordillera.atencion_service.dto.TicketClienteDTO;
import com.grupocordillera.atencion_service.model.Ticket;
import com.grupocordillera.atencion_service.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTickets(){ return ticketRepository.findAll();}

    public Optional<Ticket> getTicket(Integer id){ return ticketRepository.findById(id);}

    public Ticket saveTicket(Ticket ticket){ return ticketRepository.save(ticket);}

    public Ticket updateTicket(Integer id, Ticket ticket) {
        Optional existe = getTicket(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("No encontrado");
        } else {
            return ticketRepository.save(ticket);
        }
    }

    public void deleteTicket(Integer id){
        if(ticketRepository.existsById(id)){
            ticketRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("No encontrado");
        }
    }


    @Autowired
    private ClienteClient clienteClient;

    public TicketClienteDTO getTicketConCliente(Integer idTicket, Integer idCliente) {


        Ticket ticket =
                ticketRepository.findById(idTicket).orElse(null);

        ClienteDTO cliente =
                clienteClient.obtenerCliente(idCliente);

        TicketClienteDTO dto =
                new TicketClienteDTO();

        dto.setIdTicket(ticket.getId());
        dto.setTipoTicket(ticket.getTipoTicket().getNombre());
        dto.setEstadoTicket(ticket.getEstadoTicket().getNombre());
        dto.setCliente(cliente);
        dto.setFechaCreacion(ticket.getFechaCreacion());
        dto.setFechaCierre(ticket.getFechaCierre());

        return dto;
    }
}
