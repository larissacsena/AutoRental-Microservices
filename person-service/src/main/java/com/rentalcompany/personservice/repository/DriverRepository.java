package com.rentalcompany.personservice.repository;

import com.rentalcompany.personservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DriverRepository extends JpaRepository<Driver, UUID> {

}
