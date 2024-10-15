package com.rentalcompany.rentalservice.repository;

import com.rentalcompany.rentalservice.model.RentalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalModel, Long> {
}
