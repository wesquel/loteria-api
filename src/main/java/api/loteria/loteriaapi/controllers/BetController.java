package api.loteria.loteriaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.loteria.loteriaapi.models.Bet;
import api.loteria.loteriaapi.services.BetService;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;
    
    @GetMapping
    public Iterable<Bet> get(){
        return betService.getBets();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Bet bet){
        return betService.create(bet);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Bet bet){
        return betService.update(bet);
    }

}
