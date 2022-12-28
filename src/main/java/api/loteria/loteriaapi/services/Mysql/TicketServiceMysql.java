package api.loteria.loteriaapi.services.Mysql;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import api.loteria.loteriaapi.dtos.mappers.TicketMapper;
import api.loteria.loteriaapi.dtos.responses.TicketResponse;
import api.loteria.loteriaapi.dtos.resquests.TicketRequest;
import api.loteria.loteriaapi.models.Bet;
import api.loteria.loteriaapi.models.Ticket;
import api.loteria.loteriaapi.repositories.BetRepository;
import api.loteria.loteriaapi.repositories.TicketRepository;
import api.loteria.loteriaapi.services.TicketService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketServiceMysql implements TicketService {

    private TicketMapper ticketMapper;
    private TicketRepository ticketRepository;
    private BetRepository betRepository;

    @Override
    public List<TicketResponse> list() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(ticket -> ticketMapper.entityToTicketResponse(ticket)).collect(Collectors.toList());
    }

    @Override
    public TicketResponse save(TicketRequest ticketRequest) {
        Ticket ticket = ticketMapper.ticketRequestToEntity(ticketRequest);
        try {
            Bet bet = verifyIfBetExist(ticketRequest.getBetId());
            ticket.setBet(bet);
            if (ticket.getChosenNumbers().stream().distinct().collect(Collectors.toList()).size() != ticket.getBet().getMaxNumbersByUsers()){
                throw new DataIntegrityViolationException("Deve escolher "+ticket.getBet().getMaxNumbersByUsers()+" números distintos!");
            }
            ticketRepository.save(ticket);
        }catch(RuntimeException e){
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return ticketMapper.entityToTicketResponse(ticket);
    }

    @Override
    public TicketResponse update(Long id, TicketRequest ticketRequest) {
        Ticket ticket = verifyIfExist(id);
        updateData(ticket, ticketRequest);
        ticketRepository.save(ticket);
        return ticketMapper.entityToTicketResponse(ticket);
    }

    @Override
    public TicketResponse delete(Long id) {
        Ticket ticket = verifyIfExist(id);
        ticketRepository.delete(ticket);
        return ticketMapper.entityToTicketResponse(ticket);
    }

    protected Ticket verifyIfExist(Long id){
        return ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id)));
    }

    protected Bet verifyIfBetExist(Long id){
        return betRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id)));
    }

    protected void updateData(Ticket ticket, TicketRequest ticketRequest){
        ticket.setChosenNumbers(ticketRequest.getChosenNumbers());
    }

}
