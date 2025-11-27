package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record VeiculoPostRequestDTO(@NotBlank String marca,
                                    @NotEmpty String modelo,
                                    @NotBlank String placa) {

    public Veiculo converterVeiculo(){
        return Veiculo.builder().marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .build();
    }
}
