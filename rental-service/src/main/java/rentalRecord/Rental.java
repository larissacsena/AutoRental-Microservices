package rentalRecord;

import rentalModel.InsurancePolicy;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public record Rental(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @NotBlank
        String customer,

        @NotBlank
        String vehicle,

        @NotNull
        LocalDate startDate,

        @NotNull
        LocalDate endDate,

        @ManyToOne
        @JoinColumn(name = "insurance_policy_id")
        InsurancePolicy insurancePolicy
) {
}
