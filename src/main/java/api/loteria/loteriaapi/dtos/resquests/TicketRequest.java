package api.loteria.loteriaapi.dtos.resquests;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import api.loteria.loteriaapi.models.Bet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private long ticketId;
    
    @NotNull
    private long betId;
    @NotBlank
    private List<Integer> chosenNumbers;
}
