package api.loteria.loteriaapi.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import api.loteria.loteriaapi.dtos.responses.TicketResponse;
import api.loteria.loteriaapi.dtos.resquests.BetRequest;
import api.loteria.loteriaapi.dtos.resquests.TicketRequest;
import api.loteria.loteriaapi.models.Ticket;

@Mapper(componentModel = "spring", uses = {BetRequest.class})
public interface TicketMapper {

    @Mapping(target = "id", source = "ticketId")
    @Mapping(target = "bet", ignore = true)
    Ticket ticketRequestToEntity(TicketRequest ticketRequest);

    @Mapping(source = "id", target = "id")
    TicketResponse entityToTicketResponse(Ticket ticket);
}
