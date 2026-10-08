package senai.com.br.javacafeteria.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProdutosController {

    @GetMapping("/cardapio")
    public String cardapio() {
        return "cardapio/cardapio";
    }
}


