package api.loteria.loteriaapi.services.Mysql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import api.loteria.loteriaapi.dtos.mappers.BetMapper;
import api.loteria.loteriaapi.dtos.responses.BetResponse;
import api.loteria.loteriaapi.dtos.resquests.BetRequest;
import api.loteria.loteriaapi.models.Bet;
import api.loteria.loteriaapi.repositories.BetRepository;
import api.loteria.loteriaapi.services.BetService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BetServiceMysql implements BetService {

    private BetRepository betRepository;
    private BetMapper betMapper;

    @Override
    public List<BetResponse> list() {
        List<Bet> bets = betRepository.findAll();
        return bets.stream().map(bet -> betMapper.entityToBetResponse(bet)).collect(Collectors.toList());
    }

    @Override
    public BetResponse save(BetRequest betRequest) {
        if (betRequest.getTotalNumbers() <= betRequest.getMaxNumbersByUsers()){
            throw new DataIntegrityViolationException("Total de números deve ser menor que a quantidades por usúario!");
        }
        Bet bet = betMapper.betResquetToEntity(betRequest);
        bet.setRaffleNumbers(new ArrayList<Integer>());
        try {
            betRepository.save(bet);
        }catch(RuntimeException e){
            throw new DataIntegrityViolationException(e.getMessage());
        }
        return betMapper.entityToBetResponse(bet);
    }

    @Override
    public BetResponse update(Long id, BetRequest betRequest) {
        Bet bet = verifyIfExist(id);
        updateData(bet, betRequest);
        betRepository.save(bet);
        return betMapper.entityToBetResponse(bet);
    }

    @Override
    public BetResponse delete(Long id) {
        Bet bet = verifyIfExist(id);
        betRepository.delete(bet);
        return betMapper.entityToBetResponse(bet);
    }

    @Override
    public BetResponse getBetById(Long id) {
        Bet bet = verifyIfExist(id);
        return betMapper.entityToBetResponse(bet);
    }

    protected Bet verifyIfExist(Long id){
        return betRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("ID: %s || Não foi encontrado nenhuma entidade para o id fornecido", id)));
    }

    protected void updateData(Bet bet, BetRequest betRequest){
        if (bet.getMaxNumbersByUsers() < bet.getRaffleNumbers().size())    bet.setRaffleNumbers(betRequest.getRaffleNumbers());
    }

    private int raffleNumber(){


        return 0;
    }

}
