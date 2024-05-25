package fiap.com.br.gestaoresiduos.repository;

import fiap.com.br.gestaoresiduos.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndercoRepository extends JpaRepository<Endereco, Integer> {
}
