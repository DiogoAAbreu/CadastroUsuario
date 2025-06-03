package dev.diogoalberto.CadastroUsuario.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/wellcome")
    public String greeting(){
        return "Hi!";
    }
}
