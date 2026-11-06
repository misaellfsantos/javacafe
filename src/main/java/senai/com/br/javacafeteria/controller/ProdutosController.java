
package senai.com.br.javacafeteria.controller;

import senai.com.br.javacafeteria.model.Produto;
import senai.com.br.javacafeteria.service.ProdutoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutosController {

    private final ProdutoService produtoService;

    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/cardapio")
    public String cardapio(Model model) {

        List<Produto> produtos = produtoService.listarTodos();

        model.addAttribute("produtos", produtos);

        return "cardapio/cardapio";
    }
}
