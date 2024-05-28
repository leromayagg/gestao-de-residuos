package fiap.com.br.gestaoresiduos.service;

import fiap.com.br.gestaoresiduos.dto.agendamento.AgendamentoDto;
import fiap.com.br.gestaoresiduos.dto.agendamento.AgendametoExibicaoDto;
import fiap.com.br.gestaoresiduos.model.Agendamento;
import fiap.com.br.gestaoresiduos.repository.AgendamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public AgendametoExibicaoDto criarAgendamento(AgendamentoDto agendamentoDto) {
        Agendamento agendamento = new Agendamento();
        BeanUtils.copyProperties(agendamentoDto, agendamento);
        agendamento.setTimestamp(agendamentoDto.timestamp());
        agendamento.setStatus(agendamentoDto.status());

        Agendamento agendamentoFinal = agendamentoRepository.save(agendamento);
        return new AgendametoExibicaoDto(agendamentoFinal);
    }


    public AgendametoExibicaoDto buscarAgendamentoPorId(Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
            return new AgendametoExibicaoDto(agendamento.get());
        }else {
            throw new RuntimeException("Agendamento com ID [" + id + "]");
        }
    }



    public void deletarAgendamento(Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);

        if (agendamento.isPresent()){
            agendamentoRepository.delete(agendamento.get());
        }
        throw new RuntimeException("Agendamento com ID [" + id + "]");
    }


    public AgendametoExibicaoDto atualizarAgendamento(AgendamentoDto agendamentoDto) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(agendamentoDto.id());

        if (agendamento.isPresent()) {
            Agendamento agendamentoAtual = new Agendamento();
            BeanUtils.copyProperties(agendamentoDto, agendamentoAtual);

            agendamentoAtual.setTimestamp(agendamentoDto.timestamp());
            agendamentoAtual.setStatus(agendamentoDto.status());

            Agendamento agendamentoAtualFinal = agendamentoRepository.save(agendamentoAtual);
            return new AgendametoExibicaoDto(agendamentoAtualFinal);
        }else {
            throw new RuntimeException("Agendamento com ID [" + agendamentoDto.id() + "]");
        }
    }
}