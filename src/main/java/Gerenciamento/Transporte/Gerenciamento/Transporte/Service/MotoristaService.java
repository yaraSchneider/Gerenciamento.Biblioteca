package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.MotoristaPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.MotoristaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public Motorista addMotorista(MotoristaPostRequestDTO motoristaPostRequestDTO){
        if (motoristaRepository.existsByNome(motoristaPostRequestDTO.nome())){
            throw new RuntimeException("Motorista já existe");
        }
        return motoristaRepository.save(motoristaPostRequestDTO.converterMotorista());
    }

    public List<Motorista> buscarMotoristas(){
        return motoristaRepository.findAll();
    }

    public Motorista buscarMotoristaPorId(Integer id){
        return motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
    }

    public Motorista atualizarMotorista(Integer id,Motorista motorista){
        motorista.setId(id);
        return motoristaRepository.save(motorista);
    }

    public void deletarMotorista(Integer id){
        motoristaRepository.deleteById(id);
    }
}
