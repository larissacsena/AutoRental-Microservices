package com.rentalcompany.vehicleservice.repository;

import com.rentalcompany.vehicleservice.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, UUID> {

}