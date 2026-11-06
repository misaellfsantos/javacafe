
package senai.com.br.javacafeteria.service;

import senai.com.br.javacafeteria.model.Catalogo;
import senai.com.br.javacafeteria.repository.CatalogoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {

    private final CatalogoRepository catalogoRepository;

    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    // Listar todos os produtos
    public List<Catalogo> listarTodos() {
        return catalogoRepository.findAll();
    }

    // Buscar produto pelo ID
    public Optional<Catalogo> buscarPorId(Long id) {
        return catalogoRepository.findById(id);
    }

    // Cadastrar produto
    @Transactional
    public Catalogo cadastrar(Catalogo catalogo) {

        if (catalogo == null) {
            throw new IllegalArgumentException(
                    "O produto não pode ser nulo.");
        }

        catalogo.setId(null);

        return catalogoRepository.save(catalogo);
    }

    // Atualizar produto
    @Transactional
    public Catalogo atualizar(Long id, Catalogo catalogo) {

        Catalogo produto = catalogoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Produto não encontrado: " + id));

        produto.setNome(catalogo.getNome());
        produto.setDescricao(catalogo.getDescricao());
        produto.setCategoria(catalogo.getCategoria());
        produto.setPreco(catalogo.getPreco());
        produto.setImagem(catalogo.getImagem());
        produto.setDestaque(catalogo.getDestaque());

        return catalogoRepository.save(produto);
    }

    // Excluir produto
    @Transactional
    public void excluir(Long id) {

        Catalogo produto = catalogoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Produto não encontrado: " + id));

        catalogoRepository.delete(produto);
    }
}
