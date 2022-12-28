package api.loteria.loteriaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.loteria.loteriaapi.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
