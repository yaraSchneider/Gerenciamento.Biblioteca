package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.VeiculoPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo addVeiculo(VeiculoPostRequestDTO veiculoPostRequestDTO) {
        if (veiculoRepository.existsByPlaca(veiculoPostRequestDTO.placa())) {
            throw new RuntimeException("Placa já cadastrada!");
        }
        return veiculoRepository.save(veiculoPostRequestDTO.converterVeiculo());
    }

    public List<Veiculo> buscarVeiculo() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculoPorId(Integer id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
    }

    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculo) {
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Integer id) {
        veiculoRepository.deleteById(id);
    }
}
