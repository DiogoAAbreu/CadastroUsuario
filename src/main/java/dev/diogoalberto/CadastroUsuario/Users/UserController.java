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
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    //mostrar usuario por ID (READ)
    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    //mostrar todos usuarios (READ)
    @GetMapping("/user")
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }

    //alterar dados do usuario (UPDATE)
    @PutMapping("/user/{id}")
    public UserModel alterUserById(@PathVariable long id, @RequestBody UserModel newUser){
        return userService.alterUserById(id, newUser);
    }

    //deletar usuario (DELETE)
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
    }
}
