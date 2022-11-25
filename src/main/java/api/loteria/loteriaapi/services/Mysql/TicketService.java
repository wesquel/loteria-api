package api.loteria.loteriaapi.services.Mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.loteria.loteriaapi.models.Response;
import api.loteria.loteriaapi.models.Ticket;
import api.loteria.loteriaapi.repositories.BetRepository;
import api.loteria.loteriaapi.repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired BetRepository betRepository;

    @Autowired
    private Response response;

    public Iterable<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

    public ResponseEntity<?> create(Ticket ticket){
        System.out.println(ticket);
        /* 
        if (betRepository.existsById(ticket.getBet().getId())){
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }*/
        
        /* 
        if (ticket.getChosenNumbers().size() != ticket.getBet().getMax()){
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }

        


        return new ResponseEntity<Ticket>(ticketRepository.save(ticket), HttpStatus.OK);*/

        response.setMessage("teste!");
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }
}
