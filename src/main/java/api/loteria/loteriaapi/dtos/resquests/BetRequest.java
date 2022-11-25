package api.loteria.loteriaapi.dtos.resquests;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    
    @NotNull
    private int betId;

    @NotNull
    private List<Integer> raffleNumbers;

    @NotBlank
    private int totalNumbers;
    
    @NotBlank
    private int maxNumbersByUsers;
}
