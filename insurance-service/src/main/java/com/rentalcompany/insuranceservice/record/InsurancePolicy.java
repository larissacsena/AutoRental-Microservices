package com.rentalcompany.insuranceservice.record;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "InsurancePolicyRecord")
@Table(name = "insurance_policies")
public record InsurancePolicy(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @NotBlank
        String coverage,

        @NotNull
        BigDecimal amount,

        String details
) {
}
