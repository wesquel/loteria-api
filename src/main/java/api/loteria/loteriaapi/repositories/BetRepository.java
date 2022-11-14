package api.loteria.loteriaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.loteria.loteriaapi.models.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
    
}
