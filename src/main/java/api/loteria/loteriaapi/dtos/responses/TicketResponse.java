package api.loteria.loteriaapi.dtos.responses;

import java.util.List;

import api.loteria.loteriaapi.models.Bet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
    private Long id;
    private Bet bet;
    private List<Integer> chosenNumbers;
}
