package dev.diogoalberto.CadastroUsuario.Users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/wellcome")
    public String greeting(){
        return "Hi!";
    }

    //adicionar usuario (CREAT)
    @PostMapping("/user")
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }

    //mostrar usuario por ID (READ)
    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    //mostrar todos usuarios (READ)
    @GetMapping("/user")
    public List<UserModel> getUsers(){
        return userService.getUsers();
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
