package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    boolean existeByPlaca(String placa);
}
