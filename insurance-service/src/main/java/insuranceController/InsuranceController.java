package insuranceController;

import insuranceModel.InsurancePolicy;
import insuranceService.InsuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getInsurance(@PathVariable Long id) {
        Optional<InsurancePolicy> insurancePolicy = insuranceService.findById(id);
        return insurancePolicy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public InsurancePolicy createInsurance(@RequestBody InsurancePolicy insurancePolicy) {
        return insuranceService.save(insurancePolicy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updateInsurance(@PathVariable Long id, @RequestBody InsurancePolicy insurancePolicy) {
        Optional<InsurancePolicy> existingInsurance = insuranceService.findById(id);
        if (existingInsurance.isPresent()) {
            insurancePolicy.setId(id);
            return ResponseEntity.ok(insuranceService.save(insurancePolicy));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable Long id) {
        insuranceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
