package api.loteria.loteriaapi.dtos.responses;

import java.util.List;

import api.loteria.loteriaapi.models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetResponse {
    private Long id;
    private List<Ticket> tickets;
    private List<Integer> raffleNumbers;
    private int totalNumbers;
    private int maxNumbersByUsers;
}
