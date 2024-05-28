package fiap.com.br.gestaoresiduos.dto.agendamento;

import fiap.com.br.gestaoresiduos.enums.Status;

public record AgendamentoDto(

        Long id,
        Long timestamp,
        Status status
) {

}
