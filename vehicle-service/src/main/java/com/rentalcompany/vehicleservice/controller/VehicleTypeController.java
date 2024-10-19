package com.rentalcompany.vehicleservice.controller;

import com.rentalcompany.vehicleservice.model.VehicleTypeModel;
import com.rentalcompany.vehicleservice.service.VehicleTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/modelos-de-carros")
@RequiredArgsConstructor
public class VehicleTypeController {

    @Autowired
    private final VehicleTypeService vehicleTypeService;

    @GetMapping
    public ResponseEntity<List<VehicleTypeModel>> listAll() {
        List<VehicleTypeModel> vehicleTypeModels = vehicleTypeService.listAll();
        return ResponseEntity.ok(vehicleTypeModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VehicleTypeModel>> findById(@PathVariable UUID id) {
        Optional<VehicleTypeModel> vehicleType = vehicleTypeService.findById(id);
        return ResponseEntity.ok(vehicleType);
    }

    @PostMapping
    public ResponseEntity<VehicleTypeModel> save(@RequestBody @Valid VehicleTypeModel vehicleTypeModel) {
        VehicleTypeModel newVehicleTypeModel = vehicleTypeService.save(vehicleTypeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehicleTypeModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleTypeModel> update(@PathVariable UUID id, @RequestBody VehicleTypeModel vehicleTypeModel) {
        VehicleTypeModel updatedVehicleTypeModel = vehicleTypeService.update(id, vehicleTypeModel);
        return ResponseEntity.ok(updatedVehicleTypeModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        vehicleTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
