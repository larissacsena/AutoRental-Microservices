package com.rentalcompany.personservice.service;

import com.rentalcompany.personservice.model.Employee;
import com.rentalcompany.personservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee driver) {
        return employeeRepository.save(driver);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
