package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;


import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.EnderecoPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Endereco;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public Endereco addEndereco(EnderecoPostRequestDTO enderecoPostRequestDTO){
        if(enderecoRepository.existsByNumero(Integer.valueOf(enderecoPostRequestDTO.numero()))){
            throw new RuntimeException();
        }
        return enderecoRepository.save(enderecoPostRequestDTO.convertEndereco());
    }

    public List<Endereco> procurarEndereco(){
        return enderecoRepository.findAll();
    }
    public Endereco procurarEnderecoPorId(Integer id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()){
            return enderecoOptional.get();
        }
        throw new RuntimeException();
    }

    public Endereco atualizarEndereco(Integer id, Endereco endereco){
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Integer id){
        enderecoRepository.deleteById(id);
    }

}