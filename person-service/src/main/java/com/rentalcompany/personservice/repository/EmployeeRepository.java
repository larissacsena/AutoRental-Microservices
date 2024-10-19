
package com.rentalcompany.personservice.repository;

import com.rentalcompany.personservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}

