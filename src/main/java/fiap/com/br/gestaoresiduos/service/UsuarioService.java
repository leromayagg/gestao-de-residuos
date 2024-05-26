package fiap.com.br.gestaoresiduos.service;

import fiap.com.br.gestaoresiduos.dto.UsuarioExibicaoDto;
import fiap.com.br.gestaoresiduos.dto.UsuarioRegistroDto;
import fiap.com.br.gestaoresiduos.model.Usuario;
import fiap.com.br.gestaoresiduos.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto criarUsuario(UsuarioRegistroDto usuarioRegistroDto){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioRegistroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRegistroDto, usuario);
        usuario.setSenha(senhaCriptografada);

        Usuario userSaved = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDto(userSaved);

    }

    public UsuarioExibicaoDto getUsuarioEmail(String email) {
        UserDetails usuario = usuarioRepository.findByEmail(email);


        if (usuario.isEnabled()) {
            return new UsuarioExibicaoDto((Usuario) usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

}
