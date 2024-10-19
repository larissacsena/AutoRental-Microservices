package com.rentalcompany.vehicleservice.repository;

import com.rentalcompany.vehicleservice.model.AccessoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccessoryRepository extends JpaRepository<AccessoryModel, UUID>{
}
