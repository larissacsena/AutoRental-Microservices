package com.rentalcompany.vehicleservice.controller;

import com.rentalcompany.vehicleservice.model.AccessoryModel;
import com.rentalcompany.vehicleservice.service.AccessoryService;
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
@RequestMapping("api/accessories")
@RequiredArgsConstructor
public class AccessoryController {

    @Autowired
    private final AccessoryService accessoryService;

    @GetMapping
    public ResponseEntity<List<AccessoryModel>> listAll() {
        List<AccessoryModel> accessories = accessoryService.listAll();
        return ResponseEntity.ok(accessories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AccessoryModel>> findById(@PathVariable UUID id) {
        Optional<AccessoryModel> accessory = accessoryService.findById(id);
        return ResponseEntity.ok(accessory);
    }

    @PostMapping
    public ResponseEntity<AccessoryModel> save(@RequestBody @Valid AccessoryModel accessoryModel) {
        AccessoryModel newAccessoryModel = accessoryService.save(accessoryModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccessoryModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessoryModel> update(@PathVariable UUID id, @RequestBody AccessoryModel accessoryModel) {
        AccessoryModel updatedAccessoryModel = accessoryService.update(id, accessoryModel);
        return ResponseEntity.ok(updatedAccessoryModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        accessoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
