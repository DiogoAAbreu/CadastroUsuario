package dev.diogoalberto.CadastroUsuario.Users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Listar todos usuarios
    public List<UserDTO> getUsers(){
        //não preciso passar nenhum paramentro para a busca pois na criação da interface de repository eu ja passei os parametros necessarios
        List<UserModel> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id){
        Optional<UserModel> user = userRepository.findById(id);
        return user.map(userMapper::map).orElse(null);
    }

    public UserDTO createUser(UserDTO userDTO){
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public void deleteUserById (Long id){
        userRepository.deleteById(id);
    }

    public UserDTO alterUserById(Long id, UserDTO newUser){
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isPresent()){
            UserModel userModel = userMapper.map(newUser);
            userModel.setId(id);
            UserModel savedUser = userRepository.save(userModel);
            return userMapper.map(savedUser);
        }
        return null;
    }
}
