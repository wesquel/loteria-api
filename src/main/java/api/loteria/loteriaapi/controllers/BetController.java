package api.loteria.loteriaapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import api.loteria.loteriaapi.dtos.responses.BetResponse;
import api.loteria.loteriaapi.services.BetService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @ApiOperation(value = "List all bets in the database")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BetResponse> get() {
        System.out.println("to aqui");
        return betService.list();
    }

    @PostMapping
    public void teste() {

    }

    /*
     * 
     * @PostMapping
     * public ResponseEntity<?> create(@RequestBody Bet bet){
     * return betService.create(bet);
     * }
     * 
     * @PutMapping("/update")
     * public ResponseEntity<?> update(@RequestBody Bet bet){
     * return betService.update(bet);
     * }
     * 
     * @DeleteMapping("delete/{id}")
     * public ResponseEntity<?> remover(@PathVariable long id){
     * return betService.delete(id);
     * }
     */

}
