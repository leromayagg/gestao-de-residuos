package fiap.com.br.gestaoresiduos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRegistroDto(
        Long id,

        @NotBlank(message = "Preencha este campo")
        String nome,

        @NotBlank(message = "Preencha este campo")
        @Email(message = "O email está inválido")
        String email,

        @NotBlank(message = "Preencha este campo")
        @Size(min = 8, max = 20, message = "Deve conter entre 8 a 15 caracteres")
        String senha
) {
}
