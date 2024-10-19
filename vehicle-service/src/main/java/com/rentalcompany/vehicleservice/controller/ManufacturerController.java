package com.rentalcompany.vehicleservice.controller;

import com.rentalcompany.vehicleservice.model.ManufacturerModel;
import com.rentalcompany.vehicleservice.service.ManufacturerService;
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
@RequestMapping("api/fabricantes")
@RequiredArgsConstructor
public class ManufacturerController {

    @Autowired
    private final ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<ManufacturerModel>> listAll() {
        List<ManufacturerModel> manufacturerModels = manufacturerService.listAll();
        return ResponseEntity.ok(manufacturerModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ManufacturerModel>> findById(@PathVariable UUID id) {
        Optional<ManufacturerModel> manufacturer = manufacturerService.findById(id);
        return ResponseEntity.ok(manufacturer);
    }

    @PostMapping
    public ResponseEntity<ManufacturerModel> save(@RequestBody @Valid ManufacturerModel manufacturerModel) {
        ManufacturerModel newManufacturerModel = manufacturerService.save(manufacturerModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newManufacturerModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerModel> update(@PathVariable UUID id, @RequestBody ManufacturerModel manufacturerModel) {
        ManufacturerModel updatedManufacturerModel = manufacturerService.update(id, manufacturerModel);
        return ResponseEntity.ok(updatedManufacturerModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        manufacturerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
