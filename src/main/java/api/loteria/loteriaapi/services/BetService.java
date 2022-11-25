package api.loteria.loteriaapi.services;

import java.util.List;

import org.springframework.boot.web.servlet.ServletComponentScan;

import api.loteria.loteriaapi.dtos.responses.BetResponse;
import api.loteria.loteriaapi.dtos.resquests.BetRequest;

public interface BetService {
    List<BetResponse> list();
    BetResponse save(BetRequest betRequest);
    BetResponse update(Long id, BetRequest betRequest);
    BetResponse delete(Long id);
    BetResponse getBetById(Long id);
    List<BetResponse> getBets();
}
