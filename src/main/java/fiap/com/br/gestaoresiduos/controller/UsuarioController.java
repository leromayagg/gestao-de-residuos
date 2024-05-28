package fiap.com.br.gestaoresiduos.controller;

import fiap.com.br.gestaoresiduos.dto.UsuarioExibicaoDto;
import fiap.com.br.gestaoresiduos.dto.UsuarioRegistroDto;
import fiap.com.br.gestaoresiduos.model.Agendamento;
import fiap.com.br.gestaoresiduos.model.Usuario;
import fiap.com.br.gestaoresiduos.service.AgendamentoService;
import fiap.com.br.gestaoresiduos.service.EnderecoService;
import fiap.com.br.gestaoresiduos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody @Valid UsuarioRegistroDto usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> litarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioExibicaoDto> buscarPorId(@PathVariable Long usuarioId){
        return ResponseEntity.ok(usuarioService.buscarPorId(usuarioId));
    }


    @DeleteMapping("/usuarios/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long usuarioId){
        usuarioService.excluir(usuarioId);
    }

    @PutMapping("/usuarios")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }

}
