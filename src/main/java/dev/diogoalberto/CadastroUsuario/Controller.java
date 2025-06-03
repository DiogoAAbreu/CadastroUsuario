package dev.diogoalberto.CadastroUsuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Olá Mundo SpringBoot";
    }
}
