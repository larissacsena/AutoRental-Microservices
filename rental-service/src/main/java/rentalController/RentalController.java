package rentalController;

import rentalModel.Rental;
import rentaService.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRental(@PathVariable Long id) {
        Optional<Rental> rental = rentalService.findById(id);
        return rental.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalService.save(rental);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        Optional<Rental> existingRental = rentalService.findById(id);
        if (existingRental.isPresent()) {
            rental.setId(id);
            return ResponseEntity.ok(rentalService.save(rental));
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
