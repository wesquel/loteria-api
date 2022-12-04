package api.loteria.loteriaapi.dtos.resquests;

import java.util.List;

import javax.validation.constraints.NotNull;

import api.loteria.loteriaapi.models.Ticket;
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
public class BetRequest {
    

    private int betId;
    private List<Ticket> tickets;
    private List<Integer> raffleNumbers;

    @NotNull
    private int totalNumbers;
    @NotNull
    private int maxNumbersByUsers;
}
