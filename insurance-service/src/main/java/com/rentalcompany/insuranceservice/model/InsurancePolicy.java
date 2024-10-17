package com.rentalcompany.insuranceservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "InsurancePolicyModel")
@Table(name = "insurance_policies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coverage;
    private Double amount;
    private String details;
}


