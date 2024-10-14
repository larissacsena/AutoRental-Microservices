package insuranceModel;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coverage;
    private Double amount;
    private String details;
}


