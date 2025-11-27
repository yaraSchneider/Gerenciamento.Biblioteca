package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record MotoristaPostRequestDTO(@NotBlank String nome,
                                      @NotBlank String email,
                                      String telefone) {

    public Motorista converterMotorista() {
        return Motorista.builder().nome(this.nome)
                .email(this.email)
                .telefone(this.telefone)
                .build();
    }
}
