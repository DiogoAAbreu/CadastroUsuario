package dev.diogoalberto.CadastroUsuario.Users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Listar todos usuarios
    public List<UserModel> getUsers(){
        //não preciso passar nenhum paramentro para a busca pois na criação da interface de repository eu ja passei os parametros necessarios
        return userRepository.findAll();
    }
}
