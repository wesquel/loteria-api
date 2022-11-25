package api.loteria.loteriaapi.dtos.responses.table;

import java.util.List;

import api.loteria.loteriaapi.dtos.responses.BetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetResponseTable {
    private List<BetResponse> betResponseList;
}
