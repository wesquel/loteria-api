package api.loteria.loteriaapi.services;

import java.util.List;

import api.loteria.loteriaapi.dtos.responses.TicketResponse;
import api.loteria.loteriaapi.dtos.resquests.TicketRequest;

public interface TicketService {
    List<TicketResponse> list();
    TicketResponse save(TicketRequest ticketRequest);
    TicketResponse update(Long id, TicketRequest ticketRequest);
    TicketResponse delete(Long id);
}
