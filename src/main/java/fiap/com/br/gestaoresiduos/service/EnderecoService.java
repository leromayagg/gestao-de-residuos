package fiap.com.br.gestaoresiduos.service;

import fiap.com.br.gestaoresiduos.dto.agendamento.AgendametoExibicaoDto;
import fiap.com.br.gestaoresiduos.dto.endereco.EnderecoDto;
import fiap.com.br.gestaoresiduos.dto.endereco.EnderecoExibicaoDto;
import fiap.com.br.gestaoresiduos.model.Agendamento;
import fiap.com.br.gestaoresiduos.model.Endereco;
import fiap.com.br.gestaoresiduos.repository.EndercoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EndercoRepository enderecoRepository;

    public EnderecoExibicaoDto criaraEndereco(EnderecoDto enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        endereco.setBairro(endereco.getBairro());
        endereco.setCidade(endereco.getCidade());
        endereco.setEstado(endereco.getEstado());
        endereco.setNumero(endereco.getNumero());
        endereco.setCep(endereco.getCep());
        endereco.setRua(endereco.getRua());

        Endereco enderecoFinal = enderecoRepository.save(endereco);
        return new EnderecoExibicaoDto(enderecoFinal);
    }

    public EnderecoExibicaoDto buscaEnderecoPorId(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            return new EnderecoExibicaoDto(endereco.get());
        }else {
            throw new RuntimeException("Endereço não encontrada");
        }
    }

    public EnderecoExibicaoDto atualizarEndereco(EnderecoDto enderecoDTO) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(enderecoDTO.id());
        if (enderecoOptional.isPresent()) {
            Endereco endereco = new Endereco();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            endereco.setBairro(endereco.getBairro());
            endereco.setCidade(endereco.getCidade());
            endereco.setEstado(endereco.getEstado());
            endereco.setNumero(endereco.getNumero());
            endereco.setCep(endereco.getCep());
            endereco.setRua(endereco.getRua());
            return new EnderecoExibicaoDto(enderecoRepository.save(endereco));
        }else {
            throw new RuntimeException("Endreço não encontrado");
        }
    }

    public void excluirEndereco(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);

        if (endereco.isPresent()) {
            enderecoRepository.delete(endereco.get());
        }else {
            throw new RuntimeException("Endreço não encontrado");
        }
    }
}
