package fiap.com.br.gestaoresiduos.dto.endereco;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(

         Long id,
         String rua,
         String bairro,
         String cidade,
         String estado,
         Integer numero,
         Long cep
) {
}
