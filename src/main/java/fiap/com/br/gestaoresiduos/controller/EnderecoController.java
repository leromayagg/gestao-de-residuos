package fiap.com.br.gestaoresiduos.controller;

import fiap.com.br.gestaoresiduos.dto.endereco.EnderecoDto;
import fiap.com.br.gestaoresiduos.dto.endereco.EnderecoExibicaoDto;
import fiap.com.br.gestaoresiduos.model.Endereco;
import fiap.com.br.gestaoresiduos.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/endereco")
    public EnderecoExibicaoDto criarEndereco(@RequestBody EnderecoDto enderecoDto) {
        return enderecoService.criaraEndereco(enderecoDto);
    }

    @GetMapping("/endereco/{id}")
    public ResponseEntity<EnderecoExibicaoDto> buscarEnderecoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(enderecoService.buscaEnderecoPorId(id));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/endereco/")
    public ResponseEntity<EnderecoExibicaoDto> atualizarEndereco(@RequestBody EnderecoDto enderecoDto) {
        try {
            return ResponseEntity.ok(enderecoService.atualizarEndereco(enderecoDto));
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/endereco/{id}")
    public void excluirEndereco(@PathVariable Long id) {
        enderecoService.excluirEndereco(id);
    }

}
