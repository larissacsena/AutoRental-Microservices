package seguro.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "apolices_seguro")
public class ApoliceSeguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cobertura;
    private Double valor;
    private String detalhes;
}

