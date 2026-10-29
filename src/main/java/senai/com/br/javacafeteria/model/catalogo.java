package senai.com.br.javacafeteria.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "catalogo")
public class Catalogo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(length = 255)
    private String imagem;

    @Column(length = 50)
    private String destaque;

    // Construtor vazio exigido pelo JPA
    public Catalogo() {
    }

    // Construtor completo
    public Catalogo(
            String nome,
            String descricao,
            String categoria,
            BigDecimal preco,
            String imagem,
            String destaque) {

        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.imagem = imagem;
        this.destaque = destaque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDestaque() {
        return destaque;
    }

    public void setDestaque(String destaque) {
        this.destaque = destaque;
    }
}