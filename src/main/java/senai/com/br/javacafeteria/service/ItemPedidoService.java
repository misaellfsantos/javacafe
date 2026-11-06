
package senai.com.br.javacafeteria.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import senai.com.br.javacafeteria.model.ItemPedido;
import senai.com.br.javacafeteria.model.Pedido;
import senai.com.br.javacafeteria.model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPedidoService {

    // Adiciona um produto ao pedido
    @Transactional
    public ItemPedido adicionarItem(
            Pedido pedido,
            Produto produto,
            Integer quantidade) {

        if (pedido == null) {
            throw new IllegalArgumentException(
                    "O pedido não pode ser nulo.");
        }

        if (produto == null) {
            throw new IllegalArgumentException(
                    "O produto não pode ser nulo.");
        }

        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero.");
        }

        ItemPedido item = new ItemPedido();

        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(quantidade);

        return item;
    }

    // Calcula o subtotal de um item
    public BigDecimal calcularSubtotal(ItemPedido item) {

        if (item == null || item.getProduto() == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal preco = item.getProduto().getPreco();

        if (preco == null) {
            return BigDecimal.ZERO;
        }

        return preco.multiply(
                BigDecimal.valueOf(item.getQuantidade()));
    }

    // Calcula o total dos itens do pedido
    public BigDecimal calcularTotal(List<ItemPedido> itens) {

        if (itens == null || itens.isEmpty()) {
            return BigDecimal.ZERO;
        }

        return itens.stream()
                .map(this::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Atualiza a quantidade de um item
    public void atualizarQuantidade(
            ItemPedido item,
            Integer quantidade) {

        if (item == null) {
            throw new IllegalArgumentException(
                    "O item não pode ser nulo.");
        }

        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero.");
        }

        item.setQuantidade(quantidade);
    }

    // Remove um item da lista do pedido
    public void removerItem(
            List<ItemPedido> itens,
            ItemPedido item) {

        if (itens == null || item == null) {
            return;
        }

        itens.remove(item);
    }

    // Retorna uma lista de itens do pedido
    public List<ItemPedido> listarItens(
            List<ItemPedido> itens) {

        if (itens == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(itens);
    }
}
