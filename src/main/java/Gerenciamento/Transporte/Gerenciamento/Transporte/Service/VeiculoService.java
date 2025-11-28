package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.VeiculoPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private VeiculoRepository veiculoRepository;

    public Veiculo addVeiculo(VeiculoPostRequestDTO veiculoPostRequestDTO) {
        if (veiculoRepository.existeByPlaca(veiculoPostRequestDTO.placa())){
            throw new RuntimeException();
        } return veiculoRepository.save(veiculoPostRequestDTO.converterVeiculo());
    }

    public List<Veiculo> buscarVeiculo(){
        return veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculoPorId(Integer id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
            if (veiculo.isPresent()){
                return veiculo.get();
            }
        throw new RuntimeException();
    }

    public Veiculo atualizarVeiculo (Integer id, Veiculo veiculo){
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Integer id){
        veiculoRepository.deleteById(id);
    }
}
