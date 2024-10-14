package seguro.record;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "apolices_seguro")
public record ApoliceSeguro(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @NotBlank
        String cobertura,

        @NotNull
        BigDecimal valor,

        String detalhes
) {
}

