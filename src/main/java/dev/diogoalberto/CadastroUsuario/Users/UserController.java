package dev.diogoalberto.CadastroUsuario.Users;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/wellcome")
    public String greeting(){
        return "Hi!";
    }

    //adicionar usuario (CREAT)
    @PostMapping("/user")
    public String createUser(){
        return "User created!";
    }

    //mostrar usuario por ID (READ)
    @GetMapping("/user/:id")
    public String getUserById(){
        return "User found.";
    }

    //mostrar todos usuarios (READ)
    @GetMapping("/user")
    public String getUsers(){
        return "Users found.";
    }

    //alterar dados do usuario (UPDATE)
    @PutMapping("/user/:id")
    public String alterUserById(){
        return "User updated";
    }

    //deletar usuario (DELETE)
    @DeleteMapping("/user/:id")
    public String deleteUserById(){
        return "User deleted";
    }
}
