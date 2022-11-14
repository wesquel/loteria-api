package api.loteria.loteriaapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.loteria.loteriaapi.models.Bet;
import api.loteria.loteriaapi.models.Response;
import api.loteria.loteriaapi.repositories.BetRepository;

@Service
public class BetService {
    
    @Autowired
    private BetRepository betRepository;

    @Autowired
    private Response response;

    public Iterable<Bet> getBets(){
        return betRepository.findAll();
    }

    public ResponseEntity<?> create(Bet bet){
        
        System.out.println(bet.getMax() <= 0);
        if (bet.getMax() <= 0){
            response.setMessage("O número maximo de valores deve ser maior que zero!");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Bet>(betRepository.save(bet), HttpStatus.OK);
    }

    public ResponseEntity<?> update(Bet bet){

        if (!betRepository.existsById(bet.getId())){
            response.setMessage("id doesn't exist!");
            return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Bet>(betRepository.save(bet), HttpStatus.CREATED);
    }

}
