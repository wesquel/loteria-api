package api.loteria.loteriaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.loteria.loteriaapi.models.Bet;

public interface BetRepository extends JpaRepository<Bet, Long> {
    
}
