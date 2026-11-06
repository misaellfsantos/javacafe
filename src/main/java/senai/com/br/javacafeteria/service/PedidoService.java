
package senai.com.br.javacafeteria.service;

import senai.com.br.javacafeteria.model.Pedido;
import senai.com.br.javacafeteria.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Cadastrar pedido
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Listar todos os pedidos
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido por ID
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Excluir pedido
    public void excluir(Long id) {
        pedidoRepository.deleteById(id);
    }
}
