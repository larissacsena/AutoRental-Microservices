package com.rentalcompany.vehicleservice.controller;

import com.rentalcompany.vehicleservice.model.VehicleModel;
import com.rentalcompany.vehicleservice.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    @Autowired
    private final VehicleService vehicleService;

    @GetMapping({"/"})
    public String hello() {
        return "Hello-vehicle";
    }

    @GetMapping
    public ResponseEntity<List<VehicleModel>> listAll() {
        List<VehicleModel> vehicles = vehicleService.listAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleModel> findById(@PathVariable UUID id) {
        VehicleModel vehicle = vehicleService.findById(id);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping
    public ResponseEntity<VehicleModel> save(@RequestBody @Valid VehicleModel vehicle) {
        VehicleModel newVehicle = vehicleService.save(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleModel> update(@PathVariable UUID id, @RequestBody VehicleModel vehicle) {
        VehicleModel updatedVehicle = vehicleService.update(id, vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/disponibilidade")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable UUID id, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        boolean isAvailable = vehicleService.checkAvailability(id, startDate, endDate);
        return ResponseEntity.ok(isAvailable);
    }
}
