package api.loteria.loteriaapi.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import api.loteria.loteriaapi.dtos.responses.BetResponse;
import api.loteria.loteriaapi.dtos.resquests.BetRequest;
import api.loteria.loteriaapi.models.Bet;


@Mapper(componentModel = "spring")
public interface BetMapper {
    @Mapping(target = "bet.id", source = "betId")
    Bet betResquetToEntity(BetRequest betRequest);

    @Mapping(source = "bet.id", target = "betId")
    BetResponse entityToBetResponse(Bet bet);
}
