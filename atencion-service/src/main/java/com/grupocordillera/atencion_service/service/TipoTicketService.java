package com.grupocordillera.atencion_service.service;

import com.grupocordillera.atencion_service.model.TipoTicket;
import com.grupocordillera.atencion_service.repository.TipoTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTicketService {

    @Autowired
    private TipoTicketRepository tipoTicketRepository;

    public List<TipoTicket> getTipos(){ return tipoTicketRepository.findAll();}

    public Optional<TipoTicket> getTipo(Integer id){ return tipoTicketRepository.findById(id);}

    public TipoTicket saveTipo(TipoTicket tipoTicket){ return tipoTicketRepository.save(tipoTicket);}

    public TipoTicket updateTipo(Integer id, TipoTicket tipoTicket) {
        Optional existe = getTipo(id);

        if (existe.isEmpty()) {
            throw new RuntimeException("No encontrado");
        } else {
            return tipoTicketRepository.save(tipoTicket);
        }
    }

    public void deleteTipo(Integer id){
        if(tipoTicketRepository.existsById(id)){
            tipoTicketRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("No encontrado");
        }
    }
}
