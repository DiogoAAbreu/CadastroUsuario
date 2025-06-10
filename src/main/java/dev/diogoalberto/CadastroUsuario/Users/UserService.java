package dev.diogoalberto.CadastroUsuario.Users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public UserModel getUserById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }

    public void deleteUserById (Long id){
        userRepository.deleteById(id);
    }

    public UserModel alterUserById(Long id, UserModel newUser){
        if(userRepository.existsById(id)){
            newUser.setId(id);
            return userRepository.save(newUser);
        }
        return null;
    }
}
