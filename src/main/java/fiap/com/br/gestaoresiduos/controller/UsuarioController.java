package fiap.com.br.gestaoresiduos.controller;

import fiap.com.br.gestaoresiduos.dto.UsuarioExibicaoDto;
import fiap.com.br.gestaoresiduos.dto.UsuarioRegistroDto;
import fiap.com.br.gestaoresiduos.model.Usuario;
import fiap.com.br.gestaoresiduos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(@RequestBody @Valid UsuarioRegistroDto usuario) {
        return usuarioService.criarUsuario(usuario);
    }

//    @GetMapping("/usuarios")
//    @ResponseStatus(HttpStatus.OK)
//    public List<UsuarioExibicaoDto> listarTodos() {
//        String email = "aol";
//        return usuarioService.getUsuarioEmail(email);
//    }
}
