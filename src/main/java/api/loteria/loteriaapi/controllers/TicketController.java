package api.loteria.loteriaapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.loteria.loteriaapi.dtos.responses.TicketResponse;
import api.loteria.loteriaapi.dtos.resquests.TicketRequest;
import api.loteria.loteriaapi.services.TicketService;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ticket")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TicketController {
    
    private TicketService ticketService;

    @ApiOperation(value = "List all Tickets")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TicketResponse> get(){
        return ticketService.list();
    }

    @PostMapping
    @ApiOperation(value = "Create a new ticket in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = TicketResponse.class)
    })
    public TicketResponse create(@RequestBody @Valid TicketRequest ticketRequest){
        return ticketService.save(ticketRequest);
    }

    @ApiOperation(value = "Update a ticket in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = TicketResponse.class)
    })

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketResponse update(@PathVariable Long id,
                                             @RequestBody @Valid TicketRequest ticketRequest){
        return ticketService.update(id, ticketRequest);
    }

    @ApiOperation(value = "Delete a ticket in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = TicketResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TicketResponse delete(@PathVariable Long id){
        return ticketService.delete(id);
    }

}
