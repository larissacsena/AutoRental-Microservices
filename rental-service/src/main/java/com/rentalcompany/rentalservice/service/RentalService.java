package com.rentalcompany.rentalservice.service;

import com.rentalcompany.rentalservice.model.RentalModel;
import com.rentalcompany.rentalservice.repository.RentalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<RentalModel> findAll() {
        return rentalRepository.findAll();
    }

    public Optional<RentalModel> findById(Long id) {
        return rentalRepository.findById(id);
    }

    public RentalModel save(RentalModel rentalModel) {
        return rentalRepository.save(rentalModel);
    }

    public void delete(Long id) {
        rentalRepository.deleteById(id);
    }
}
