package fiap.com.br.gestaoresiduos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioLoginDto(

        @NotBlank(message = "Preencha este campo")
        @Email(message = "O email está inválido")
        String email,

        @NotBlank(message = "Preencha este campo")
        String senha
) {
}
