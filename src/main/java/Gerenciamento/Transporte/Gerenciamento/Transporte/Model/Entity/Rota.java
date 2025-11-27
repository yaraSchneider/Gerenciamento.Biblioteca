package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_rota")
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne
    private Endereco origem;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne
    private Endereco destino;

    @Column(nullable = false)
    private Double distancia;

    @ManyToOne
    private Motorista motorista;
}
