package com.rentalcompany.insuranceservice.repository;

import com.rentalcompany.insuranceservice.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
}
