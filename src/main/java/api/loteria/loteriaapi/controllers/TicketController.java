package api.loteria.loteriaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.loteria.loteriaapi.models.Ticket;
import api.loteria.loteriaapi.services.Mysql.TicketService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ticket")
public class TicketController {
    
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public Iterable<Ticket> getTickets(){
       return ticketService.getTickets(); 
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Ticket ticket) {
        System.out.println(ticket.getChosenNumbers());        
        return ticketService.create(ticket);
    }
    
        

}
