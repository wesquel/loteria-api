package api.loteria.loteriaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.loteria.loteriaapi.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
