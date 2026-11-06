package senai.com.br.javacafeteria.service;

import senai.com.br.javacafeteria.model.Clientes;
import senai.com.br.javacafeteria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Cadastrar cliente
    public Clientes salvar(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos os clientes
    public List<Clientes> listarTodos() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Optional<Clientes> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Excluir cliente
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}