package seguro.service;

import seguro.model.ApoliceSeguro;
import seguro.repository.ApoliceSeguroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroService {
    private final ApoliceSeguroRepository apoliceSeguroRepository;

    public SeguroService(ApoliceSeguroRepository apoliceSeguroRepository) {
        this.apoliceSeguroRepository = apoliceSeguroRepository;
    }

    public List<ApoliceSeguro> listarTodos() {
        return apoliceSeguroRepository.findAll();
    }

    public Optional<ApoliceSeguro> buscarPorId(Long id) {
        return apoliceSeguroRepository.findById(id);
    }

    public ApoliceSeguro salvar(ApoliceSeguro apoliceSeguro) {
        return apoliceSeguroRepository.save(apoliceSeguro);
    }

    public void deletar(Long id) {
        apoliceSeguroRepository.deleteById(id);
    }
}
