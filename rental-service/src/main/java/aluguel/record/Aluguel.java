package aluguel.record;

import aluguel.model.ApoliceSeguro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "alugueis")
public record Aluguel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @NotBlank
        String cliente,

        @NotBlank
        String veiculo,

        @NotNull
        LocalDate dataInicio,

        @NotNull
        LocalDate dataFim,

        @ManyToOne
        @JoinColumn(name = "apolice_seguro_id")
        ApoliceSeguro apoliceSeguro
) {
}

