package fiap.com.br.gestaoresiduos.repository;

import fiap.com.br.gestaoresiduos.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
