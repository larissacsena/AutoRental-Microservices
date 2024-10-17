package com.rentalcompany.vehicleservice.repository;

import com.rentalcompany.vehicleservice.model.ManufacturerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ManufacturerRepository extends JpaRepository<ManufacturerModel, UUID>{
}
