package com.rentalcompany.insuranceservice.service;

import com.rentalcompany.insuranceservice.model.InsurancePolicy;
import com.rentalcompany.insuranceservice.repository.InsurancePolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    private final InsurancePolicyRepository insurancePolicyRepository;

    public InsuranceService(InsurancePolicyRepository insurancePolicyRepository) {
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    public List<InsurancePolicy> findAll() {
        return insurancePolicyRepository.findAll();
    }

    public Optional<InsurancePolicy> findById(Long id) {
        return insurancePolicyRepository.findById(id);
    }

    public InsurancePolicy save(InsurancePolicy insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public void delete(Long id) {
        insurancePolicyRepository.deleteById(id);
    }
}
