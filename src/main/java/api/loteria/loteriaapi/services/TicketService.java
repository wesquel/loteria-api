package api.loteria.loteriaapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.loteria.loteriaapi.models.Response;
import api.loteria.loteriaapi.models.Ticket;
import api.loteria.loteriaapi.repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private Response response;

    public ResponseEntity<?> create(Ticket ticket){

        

        return new ResponseEntity<Ticket>(ticketRepository.save(ticket), HttpStatus.OK);
    }
}
