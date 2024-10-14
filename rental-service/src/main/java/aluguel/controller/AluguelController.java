package aluguel.controller;

import aluguel.model.Aluguel;
import aluguel.service.AluguelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> obterAluguel(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelService.buscarPorId(id);
        return aluguel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluguel criarAluguel(@RequestBody Aluguel aluguel) {
        return aluguelService.salvar(aluguel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluguel> atualizarAluguel(@PathVariable Long id, @RequestBody Aluguel aluguel) {
        Optional<Aluguel> aluguelExistente = aluguelService.buscarPorId(id);
        if (aluguelExistente.isPresent()) {
            aluguel.setId(id);
            return ResponseEntity.ok(aluguelService.salvar(aluguel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long id) {
        aluguelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
