package api.loteria.loteriaapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import api.loteria.loteriaapi.dtos.responses.BetResponse;
import api.loteria.loteriaapi.dtos.resquests.BetRequest;
import api.loteria.loteriaapi.services.BetService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bet")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BetController {

    private BetService betService;

    @ApiOperation(value = "List all bets")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BetResponse> get() {
        return betService.list();
    }

    @PostMapping
    @ApiOperation(value = "Create a new bet in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = BetResponse.class)
    })
    public BetResponse create(@RequestBody @Valid BetRequest betRequest) {
        return betService.save(betRequest);
    }

    @ApiOperation(value = "Update a bet in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = BetResponse.class)
    })

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BetResponse update(@PathVariable Long id, 
        @RequestBody @Valid BetRequest betRequest, 
        @RequestParam(required = false) String raffleNumber

    ){
        return betService.update(id, betRequest);
    }

    @ApiOperation(value = "Delete a bet in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = BetResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BetResponse delete(@PathVariable Long id){
        return betService.delete(id);
    }

}
