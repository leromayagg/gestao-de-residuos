package fiap.com.br.gestaoresiduos.service;

import fiap.com.br.gestaoresiduos.dto.UsuarioExibicaoDto;
import fiap.com.br.gestaoresiduos.dto.UsuarioRegistroDto;
import fiap.com.br.gestaoresiduos.model.Usuario;
import fiap.com.br.gestaoresiduos.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDto(usuarioSalvo);

    }

    public List<UsuarioExibicaoDto> listarTodos(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }

}
