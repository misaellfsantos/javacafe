package senai.com.br.javacafeteria;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefone;

    // getters e setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Entity
    @Table(name = "contas_pagamento")
    public static class ContaPagamento {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "pedido_id", nullable = false)
        private Pedido pedido;

        @Column(nullable = false)
        private BigDecimal valor;

        @Enumerated(EnumType.STRING)
        private FormaPagamento formaPagamento;

        @Enumerated(EnumType.STRING)
        private StatusPagamento status;

        private LocalDateTime dataPagamento;



    }
}