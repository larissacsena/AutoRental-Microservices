package com.rentalcompany.rentalservice.controller;

import com.rentalcompany.rentalservice.model.RentalModel;
import com.rentalcompany.rentalservice.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello-rental");

    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Endpoint test funcionando");
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalModel> getRental(@PathVariable Long id) {
        Optional<RentalModel> rental = rentalService.findById(id);
        return rental.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RentalModel createRental(@RequestBody RentalModel rentalModel) {
        return rentalService.save(rentalModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalModel> updateRental(@PathVariable Long id, @RequestBody RentalModel rentalModel) {
        Optional<RentalModel> existingRental = rentalService.findById(id);
        if (existingRental.isPresent()) {
            rentalModel.setId(id);
            return ResponseEntity.ok(rentalService.save(rentalModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
