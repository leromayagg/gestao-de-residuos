package fiap.com.br.gestaoresiduos.dto.endereco;

import fiap.com.br.gestaoresiduos.model.Endereco;
import jakarta.validation.constraints.NotBlank;

public record EnderecoExibicaoDto(
        Long id,
        String rua,
        String bairro,
        String cidade,
        String estado,
        Integer numero,
        Long cep

) {
    public EnderecoExibicaoDto (Endereco endereco){
        this(
                endereco.getId(),
                endereco.getRua(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getNumero(),
                endereco.getCep()
        );
    }
}
