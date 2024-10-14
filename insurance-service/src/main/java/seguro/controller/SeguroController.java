package seguro.controller;

import seguro.model.ApoliceSeguro;
import seguro.service.SeguroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/seguros")
public class SeguroController {
    private final SeguroService seguroService;

    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoliceSeguro> obterSeguro(@PathVariable Long id) {
        Optional<ApoliceSeguro> apoliceSeguro = seguroService.buscarPorId(id);
        return apoliceSeguro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ApoliceSeguro criarSeguro(@RequestBody ApoliceSeguro apoliceSeguro) {
        return seguroService.salvar(apoliceSeguro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApoliceSeguro> atualizarSeguro(@PathVariable Long id, @RequestBody ApoliceSeguro apoliceSeguro) {
        Optional<ApoliceSeguro> seguroExistente = seguroService.buscarPorId(id);
        if (seguroExistente.isPresent()) {
            apoliceSeguro.setId(id);
            return ResponseEntity.ok(seguroService.salvar(apoliceSeguro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSeguro(@PathVariable Long id) {
        seguroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

