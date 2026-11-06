package senai.com.br.javacafeteria.service;

import senai.com.br.javacafeteria.model.Conta;
import senai.com.br.javacafeteria.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    // Cadastrar conta
    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    // Listar todas as contas
    public List<Conta> listarTodos() {
        return contaRepository.findAll();
    }

    // Buscar conta por ID
    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }

    // Excluir conta
    public void excluir(Long id) {
        contaRepository.deleteById(id);
    }
}