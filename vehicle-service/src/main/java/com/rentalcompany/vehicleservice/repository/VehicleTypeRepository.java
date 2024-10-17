package com.rentalcompany.vehicleservice.repository;

import com.rentalcompany.vehicleservice.model.VehicleTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleTypeRepository extends JpaRepository<VehicleTypeModel, UUID>  {
}
