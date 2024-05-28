package fiap.com.br.gestaoresiduos.dto.agendamento;

import fiap.com.br.gestaoresiduos.enums.Status;
import fiap.com.br.gestaoresiduos.model.Agendamento;

public record AgendametoExibicaoDto(
        Long id,
        Long timestamp,
        Status status

) {
    public AgendametoExibicaoDto (Agendamento agendamento){
        this(
                agendamento.getId(),
                agendamento.getTimestamp(),
                agendamento.getStatus()
        );
    }
}
