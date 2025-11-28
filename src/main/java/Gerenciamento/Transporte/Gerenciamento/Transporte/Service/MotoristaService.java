package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.MotoristaPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.MotoristaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MotoristaService {

    private MotoristaRepository motoristaRepository;

    public Motorista addMotorista(MotoristaPostRequestDTO motoristaPostRequestDTO){
        if(motoristaRepository.existsByNome(motoristaPostRequestDTO.nome())){
            throw new RuntimeException();
        } return motoristaRepository.save(motoristaPostRequestDTO.converterMotorista());
    }

    public List<Motorista> buscarMotoristas(){
        return motoristaRepository.findAll();
    }

    public Motorista buscarMotoristaPorId(Integer id){
        Optional<Motorista> motoristaOptional = motoristaRepository.findById(id);
            if (motoristaOptional.isPresent()){
                return motoristaOptional.get();
        } throw new RuntimeException();
    }

    public Motorista atualizarMotorista(Integer id,Motorista motorista){
        motorista.setId(id);
        return motoristaRepository.save(motorista);
    }

    public void deletarMotorista(Integer id){
        motoristaRepository.deleteById(id);
    }

}
