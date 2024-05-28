package fiap.com.br.gestaoresiduos.service;

import fiap.com.br.gestaoresiduos.dto.UsuarioExibicaoDto;
import fiap.com.br.gestaoresiduos.dto.UsuarioRegistroDto;
import fiap.com.br.gestaoresiduos.exception.UsuarioNaoEncontradoException;
import fiap.com.br.gestaoresiduos.model.Usuario;
import fiap.com.br.gestaoresiduos.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public UsuarioExibicaoDto buscarPorId(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não existe no banco de dados!");
        }
    }

    public List<UsuarioExibicaoDto> listarTodos(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }

    public void excluir(Long id){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public Usuario atualizar(Usuario usuario){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(usuario.getId());

        if (usuarioOptional.isPresent()){
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

}
