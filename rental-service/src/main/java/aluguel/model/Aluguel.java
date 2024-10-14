package aluguel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "alugueis")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double valorTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_id", referencedColumnName = "id")
    private ApoliceSeguro apoliceSeguro;
}


