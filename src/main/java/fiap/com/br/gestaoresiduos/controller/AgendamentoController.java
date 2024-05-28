package fiap.com.br.gestaoresiduos.controller;

import fiap.com.br.gestaoresiduos.dto.agendamento.AgendamentoDto;
import fiap.com.br.gestaoresiduos.dto.agendamento.AgendametoExibicaoDto;
import fiap.com.br.gestaoresiduos.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;


    @PostMapping("/agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public AgendametoExibicaoDto criarAgendamento(@RequestBody AgendamentoDto agendamentoDto) {
        return agendamentoService.criarAgendamento(agendamentoDto);
    }



    @GetMapping("/agendamento/{id}")
    public ResponseEntity<AgendametoExibicaoDto> buscarAgendamentoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(agendamentoService.buscarAgendamentoPorId(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/agendamento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
    }

    @PutMapping("/agendamento/{id}")
    public ResponseEntity<AgendametoExibicaoDto> atualizarAgendamento(@RequestBody AgendamentoDto agendamentoDto) {
        try {
            return ResponseEntity.ok(agendamentoService.atualizarAgendamento(agendamentoDto));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


}
