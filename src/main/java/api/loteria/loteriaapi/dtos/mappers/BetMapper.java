package api.loteria.loteriaapi.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import api.loteria.loteriaapi.dtos.responses.BetResponse;
import api.loteria.loteriaapi.dtos.resquests.BetRequest;
import api.loteria.loteriaapi.models.Bet;


@Mapper(componentModel = "spring")
public interface BetMapper {

    @Mapping(target="id", source="betId")
    @Mapping(target="totalNumbers", source="betRequest.totalNumbers")
    Bet betResquetToEntity(BetRequest betRequest);

    @Mapping(target="id", source="id")
    BetResponse entityToBetResponse(Bet bet);
}
