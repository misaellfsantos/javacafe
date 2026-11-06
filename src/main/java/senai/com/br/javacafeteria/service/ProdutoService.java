
package senai.com.br.javacafeteria.service;

import senai.com.br.javacafeteria.model.Produto;
import senai.com.br.javacafeteria.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Cadastrar produto
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Excluir produto
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
}
