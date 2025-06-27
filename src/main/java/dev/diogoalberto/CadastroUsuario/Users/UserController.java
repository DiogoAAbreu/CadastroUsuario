package dev.diogoalberto.CadastroUsuario.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createUser(userDTO);
        if(user != null){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível criar um novo usuário...");
    }

    //mostrar usuario por ID (READ)
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id){
        UserDTO userDTO =  userService.getUserById(id);
        if (userDTO != null){
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID " + id + " não encontrado...");
    }

    //mostrar todos usuarios (READ)
    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    //alterar dados do usuario (UPDATE)
    @PutMapping("/user/{id}")
    public ResponseEntity<?> alterUserById(@PathVariable long id, @RequestBody UserDTO newUser){
        UserDTO userDTO = userService.getUserById(id);
        if (userDTO != null){
            UserDTO userUpdated = userService.alterUserById(id, newUser);
            return ResponseEntity.ok(userUpdated);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com ID " + id + " não encontrado...");
        }


    //deletar usuario (DELETE)
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id){
        if(userService.getUserById(id) != null){
            userService.deleteUserById(id);
            return ResponseEntity.ok("Usuário com ID " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com ID " + id + " não encontrado...");
        }
    }
}
