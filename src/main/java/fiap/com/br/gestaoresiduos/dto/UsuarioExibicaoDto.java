package fiap.com.br.gestaoresiduos.dto;

import fiap.com.br.gestaoresiduos.enums.Role;
import fiap.com.br.gestaoresiduos.model.Usuario;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String email,
        Role role
) {
    public UsuarioExibicaoDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole());
    }
}
